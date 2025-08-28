package com.example.insy7315_poe_p1_v1
import com.example.insy7315_poe_p1_v1.Tenant_Fragments.HomeFragment
import com.example.insy7315_poe_p1_v1.Tenant_Fragments.MaintenanceFragment
import com.example.insy7315_poe_p1_v1.Tenant_Fragments.PaymentHistoryFragment

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Tenant_Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tenant_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Enables back button on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        supportFragmentManager.addOnBackStackChangedListener {
            val canGoBack = supportFragmentManager.backStackEntryCount > 0
            supportActionBar?.setDisplayHomeAsUpEnabled(canGoBack)
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.nav_maintenance -> {
                    replaceFragment(MaintenanceFragment())
                    true
                }

                R.id.nav_messages -> {
                    //replaceFragment(MessagesFragment())
                    true
                }

                R.id.nav_profile -> {
                    //replaceFragment(ProfileFragment())
                    true
                }

                R.id.nav_payments -> {
                    replaceFragment(PaymentHistoryFragment())
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}