package com.example.insy7315_poe_p1_v1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.insy7315_poe_p1_v1.Services.LoginService
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.SignInButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        val login = findViewById<Button>(R.id.btnLogin)
        val signup = findViewById<TextView>(R.id.tvSignup)
        val googleLogin = findViewById<SignInButton>(R.id.btnGoogleLogin)

        val emailInput = findViewById<EditText>(R.id.etEmailAddress)
        val passwordInput = findViewById<EditText>(R.id.etPassword)

        login.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            LoginService.authenticateUser(email, password) { user ->
                if (user == null) {
                    runOnUiThread {
                        emailInput.error = "Invalid email or password"
                        passwordInput.error = "Invalid email or password"
                    }
                } else {
                    val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                    with(sharedPref.edit()) {
                        putString("userType", user.userType)
                        apply()
                    }

                    when (user.userType) {
                        "Tenant" -> startActivity(Intent(this, Tenant_Home::class.java))
                        "Manager" -> startActivity(Intent(this, Manager_Home::class.java))
                        "Caretaker" -> startActivity(Intent(this, Caretaker_Home::class.java))
                        "Admin" -> startActivity(Intent(this, Admin_Home::class.java))
                        else -> Log.w("MainActivity", "Unknown user type: ${user.userType}")
                    }
                    finish()
                }
            }
        }

        googleLogin.setOnClickListener {
            googleSignInClient.signOut().addOnCompleteListener {
                googleSignInClient.revokeAccess().addOnCompleteListener {
                    launcher.launch(googleSignInClient.signInIntent)
                }
            }
        }

        signup.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
            finish()
        }
    }

    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)

            auth.signInWithCredential(credential).addOnCompleteListener { authTask ->
                if (authTask.isSuccessful) {
                    val user = auth.currentUser
                    if (user != null) {
                        val email = user.email ?: return@addOnCompleteListener

                        val userRef = db.collection("users").document(user.uid)
                        userRef.get().addOnSuccessListener { document ->
                            if (!document.exists()) {
                                val userData = hashMapOf(
                                    "name" to (user.displayName ?: ""),
                                    "phoneNumber" to (user.phoneNumber ?: ""),
                                    "email" to email,
                                    "signInMethod" to "google",
                                    "createdAt" to FieldValue.serverTimestamp(),
                                    "preferences" to mapOf(
                                        "language" to "en",
                                        "theme" to "light",
                                        "notifications" to true
                                    ),
                                    "located" to "",
                                    "status" to "",
                                    "userType" to "Tenant"
                                )
                                userRef.set(userData)
                            }
                        }
                    }

                    Toast.makeText(this, "Google Sign-In successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, Tenant_Home::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Google Sign-In failed", Toast.LENGTH_LONG).show()
                }
            }
        } catch (e: ApiException) {
            Log.e("GoogleLogin", "Sign-In failed: ${e.statusCode}")
            Toast.makeText(this, "Google Sign-In failed", Toast.LENGTH_LONG).show()
        }
    }
}
