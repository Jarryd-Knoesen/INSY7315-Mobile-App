package com.example.insy7315_poe_p1_v1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val login = findViewById<Button>(R.id.btnLogin)
        val signup = findViewById<TextView>(R.id.tvSignup)

        val emailInput = findViewById<EditText>(R.id.etEmailAddress)
        val passwordInput = findViewById<EditText>(R.id.etPassword)

        login.setOnClickListener {
            // error check user authentication
//            val email = emailInput.text.toString()
//            val password = passwordInput.text.toString()
//
//            if (!isUserValid(password, email)) {
//                emailInput.error = "Email or Password is invalid"
//                passwordInput.error = "Email or Password is invalid"
//                return@setOnClickListener
//            }

//            val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
//            with(sharedPref.edit()) {
//                putString("userType", "Guest") //this will be to determine the user type
//                apply()
//            }

            val userType = "Tenant";

            if (userType == "Tenant") {
                startActivity(Intent(this, Tenant_Home::class.java))
                finish()
            }

            if (userType == "Manager") {
                //startActivity(Intent(this, Manager_Home::class.java))
                finish()
            }

            if (userType == "Caretaker") {
                //startActivity(Intent(this, Caretaker_Home::class.java))
                finish()
            }

            if (userType == "Admin") {
                startActivity(Intent(this, Admin_Home::class.java))
                finish()
            }
        }

        signup.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
            finish()
        }

    }

    fun isUserValid(password: String, email: String): Boolean {
        // put the code to check the database here
        return true
    }
}