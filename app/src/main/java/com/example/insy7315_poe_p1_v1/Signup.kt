package com.example.insy7315_poe_p1_v1

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signup = findViewById<Button>(R.id.btnSignup)
        val login = findViewById<TextView>(R.id.tvLogin)

        // Gets the user input from the text fields
        val firstNameInput = findViewById<TextView>(R.id.etFirstName)
        val surnameInput = findViewById<TextView>(R.id.etSurname)
        val phoneNumberInput = findViewById<TextView>(R.id.etPhoneNumber)
        val emailInput = findViewById<TextView>(R.id.etEmail)
        val passwordInput = findViewById<TextView>(R.id.etPassword)

        signup.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            val firstName = firstNameInput.text.toString()
            val surname = surnameInput.text.toString()
            val phoneNumber = phoneNumberInput.text.toString()

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

            startActivity(Intent(this, MainActivity::class.java))
        }

        login.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    fun isValidName(name: String): Boolean {
        return name.isNotEmpty() && name.all { it.isLetter() }
    }

    fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        val regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
        return password.matches(regex.toRegex())
    }

    fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val regex = "^\\d{10}$"
        return phoneNumber.matches(regex.toRegex())
    }
}