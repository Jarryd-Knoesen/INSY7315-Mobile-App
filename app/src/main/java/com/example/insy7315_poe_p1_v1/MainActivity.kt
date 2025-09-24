package com.example.insy7315_poe_p1_v1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.insy7315_poe_p1_v1.Models.UsersModel
import com.example.insy7315_poe_p1_v1.Models.UsersRepository
import android.util.Log
import com.example.insy7315_poe_p1_v1.Services.LoginService
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize shared preferences with default values if they don't exist
        val sharedPref = getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
        if (!sharedPref.contains("DarkMode")) {
            with(sharedPref.edit()) {
                putBoolean("DarkMode", false)
                putString("Language", "en")
                apply()
            }
        }

//        val oldDoc = "A11"
//        val newDoc = "A101"
//        val oldDoc2 = "B11"
//        val newDoc2 = "A102"
//
//        CoroutineScope(Dispatchers.IO).launch {
//            renameLeaseDocument(oldDoc, newDoc)
//            renameLeaseDocument(oldDoc2, newDoc2)
//        }


        val login = findViewById<Button>(R.id.btnLogin)
        val signup = findViewById<TextView>(R.id.tvSignup)

        val emailInput = findViewById<EditText>(R.id.etEmailAddress)
        val passwordInput = findViewById<EditText>(R.id.etPassword)

        login.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            // Call the service instead of local repo
            LoginService.authenticateUser(email, password) { user ->
                if (user == null) {
                    runOnUiThread {

                        emailInput.error = "Invalid email or password"
                        passwordInput.error = "Invalid email or password"
                    }
                } else {
                    // Save userType in SharedPreferences
                    val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                    with(sharedPref.edit()) {
                        putString("userType", user.userType)
                        apply()
                    }

                    // Redirect by user type
                    when (user.userType) {
                        "Tenant" -> {
                            startActivity(Intent(this, Tenant_Home::class.java))
                            finish()
                        }
                        "Manager" -> {
                            startActivity(Intent(this, Manager_Home::class.java))
                            finish()
                        }
                        "Caretaker" -> {
                            startActivity(Intent(this, Caretaker_Home::class.java))
                            finish()
                        }
                        "Admin" -> {
                            startActivity(Intent(this, Admin_Home::class.java))
                            finish()
                        }
                        else -> {
                            Log.w("MainActivity", "Unknown user type: ${user.userType}")
                        }
                    }
                }
            }
        }


        signup.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
            finish()
        }

        // database
//        val dbTest2 = Firebase.firestore
//        // Writing to the DB
//        dbTest2.collection("tester").document("test")
//            .set(mapOf("status" to "Working"))
//            .addOnSuccessListener { Log.d("Firestore", "Write successful") }
//            .addOnFailureListener { e -> Log.e("Firestore", "Write failed", e) }
//
//        // Reading from the DB
//        dbTest2.collection("tester").document("test")
//            .get()
//            .addOnSuccessListener { document ->
//                if (document != null && document.exists()) {
//                    val status = document.getString("status") ?: "No value"
//                    emailInput.hint = status
//                    Log.d("Firestore", "Fetched status: $status")
//                } else {
//                    Log.w("Firestore", "No such document")
//                }
//            }
//            .addOnFailureListener { e ->
//                Log.e("Firestore", "Read failed", e)
//            }

    }

    fun getUserIfValid(password: String, email: String): UsersModel? {
        return UsersRepository.users.find {
            it.email == email && it.password == password
        }
    }

    suspend fun renameLeaseDocument(oldId: String, newId: String) {
        val db = Firebase.firestore
//        val oldDocRef = db.collection("properties/Birchleigh/units").document(oldId)
//        val newDocRef = db.collection("properties/Birchleigh/units").document(newId)
        val oldDocRef = db.collection("properties").document("Birchleigh").collection("units").document(oldId)
        val newDocRef = db.collection("properties").document("Birchleigh").collection("units").document(newId)


        try {
            val snapshot = oldDocRef.get().await()
            if (snapshot.exists()) {
                val data = snapshot.data

                if (data != null) {
                    newDocRef.set(data).await()

                    oldDocRef.delete().await()
                }
            } else {
                println("No such document")
            }
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }
}