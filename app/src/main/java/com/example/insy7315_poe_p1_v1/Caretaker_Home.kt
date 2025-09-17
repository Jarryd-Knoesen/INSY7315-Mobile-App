package com.example.insy7315_poe_p1_v1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.core.view.WindowInsetsCompat
import com.example.insy7315_poe_p1_v1.Caretaker_Fragments.TasksFragment
import com.example.insy7315_poe_p1_v1.FragmentsForAll.ProfileFragment
import com.example.insy7315_poe_p1_v1.FragmentsForAll.UsersListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.Firebase
import com.google.firebase.analytics.analytics

class Caretaker_Home : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_caretaker_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TasksFragment())
                .commit()
        }
        val bundle = Bundle().apply {
            putString("user_type", "caretaker")
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_maintenance -> {
                    Firebase.analytics.logEvent("Tasks_button_click", bundle)
                    replaceFragment(TasksFragment())
                    true
                }

                R.id.nav_communication -> {
                    Firebase.analytics.logEvent("Communication_button_click", bundle)
                    replaceFragment(UsersListFragment())
                    true
                }

                R.id.nav_profile -> {
                    Firebase.analytics.logEvent("Profile_button_click", bundle)
                    replaceFragment(ProfileFragment())
                    true
                }

                else -> false
            }
        }
    }

    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }
}