package com.example.insy7315_poe_p1_v1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FieldValue

class Signup : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private val db = FirebaseFirestore.getInstance()

    private val RC_SIGN_IN = 9001

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

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

        val firstNameInput = findViewById<EditText>(R.id.etFirstName)
        val surnameInput = findViewById<EditText>(R.id.etSurname)
        val phoneNumberInput = findViewById<EditText>(R.id.etPhoneNumber)
        val emailInput = findViewById<EditText>(R.id.etEmail)
        val passwordInput = findViewById<EditText>(R.id.etPassword)
        val signupButton = findViewById<Button>(R.id.btnSignup)
        val loginText = findViewById<TextView>(R.id.tvLogin)
        val googleSignInButton = findViewById<com.google.android.gms.common.SignInButton>(R.id.sign_in_button)

        signupButton.setOnClickListener {
            val firstName = firstNameInput.text.toString().trim()
            val surname = surnameInput.text.toString().trim()
            val phoneNumber = phoneNumberInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (!isValidName(firstName)) {
                firstNameInput.error = "Please enter your first name"
                return@setOnClickListener
            }
            if (!isValidName(surname)) {
                surnameInput.error = "Please enter your surname"
                return@setOnClickListener
            }
            if (!isValidPhoneNumber(phoneNumber)) {
                phoneNumberInput.error = "Please enter a valid phone number"
                return@setOnClickListener
            }
            if (!isValidEmail(email)) {
                emailInput.error = "Please enter a valid email address"
                return@setOnClickListener
            }
            if (!isValidPassword(password)) {
                passwordInput.error = "Password must contain 8+ characters, 1 upper, 1 lower, 1 number, and 1 symbol"
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    if (user != null) {
                        val userData = hashMapOf(
                            "name" to "$firstName $surname",
                            "phoneNumber" to phoneNumber,
                            "email" to email,
                            "signInMethod" to "password",
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
                        db.collection("users").document(user.uid)
                            .set(userData)
                            .addOnSuccessListener {
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            }
                            .addOnFailureListener { e ->
                                Toast.makeText(this, "Error saving user: ${e.message}", Toast.LENGTH_LONG).show()
                            }
                    }
                } else {
                    emailInput.error = "Authentication failed: ${task.exception?.message}"
                }
            }
        }

        loginText.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // Google Sign-In
        val googleSignInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                val account = task.result
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
                                        "name" to user.displayName?.split(" ")?.firstOrNull() + " " + user.displayName?.split(" ")?.getOrNull(1),
                                        "phoneNumber" to (user.phoneNumber ?: ""),
                                        "email" to email,
                                        "signInMethod" to "google",
                                        "createdAt" to FieldValue.serverTimestamp(),
                                        "uid" to user.email,
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
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Google sign-in failed", Toast.LENGTH_LONG).show()
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Google sign-in error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

        googleSignInButton.setOnClickListener {
            googleSignInClient.signOut().addOnCompleteListener {
                googleSignInClient.revokeAccess().addOnCompleteListener {
                    val signInIntent = googleSignInClient.signInIntent
                    googleSignInLauncher.launch(signInIntent)
                }
            }
        }
    }

    private fun isValidName(name: String) = name.isNotEmpty() && name.all { it.isLetter() }
    private fun isValidEmail(email: String) = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isValidPassword(password: String) =
        password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$".toRegex())

    private fun isValidPhoneNumber(phoneNumber: String) =
        phoneNumber.matches("^\\d{10}$".toRegex())
}
