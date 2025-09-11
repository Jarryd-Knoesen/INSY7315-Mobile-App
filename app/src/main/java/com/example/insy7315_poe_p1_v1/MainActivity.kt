package com.example.insy7315_poe_p1_v1

import android.annotation.SuppressLint
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


        val login = findViewById<Button>(R.id.btnLogin)
        val signup = findViewById<TextView>(R.id.tvSignup)

        val emailInput = findViewById<EditText>(R.id.etEmailAddress)
        val passwordInput = findViewById<EditText>(R.id.etPassword)

        login.setOnClickListener {
            // error check user authentication
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            val user = getUserIfValid(password, email)

            if (user == null) {
                emailInput.error = "Invalid email or password"
                passwordInput.error = "Invalid email or password"
                return@setOnClickListener
            }

            // Redirect userType to sharedPreferences
            val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("userType", user.userType) //this will be to determine the user type
                apply()
            }

            when (user.userType) {
                "Tenant" -> {
                    startActivity(Intent(this, Tenant_Home::class.java))
                    finish()
                }
                "Manager" -> {
                    // startActivity(Intent(this, Manager_Home::class.java))
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
            }

        }

        signup.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
            finish()
        }

    }

    fun getUserIfValid(password: String, email: String): UsersModel? {
        return UsersRepository.users.find {
            it.email == email && it.password == password
        }
    }
}