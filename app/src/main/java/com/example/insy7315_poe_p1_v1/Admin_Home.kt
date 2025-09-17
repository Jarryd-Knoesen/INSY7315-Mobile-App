package com.example.insy7315_poe_p1_v1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.Admin_Fragments.EscalationsFragment
import com.example.insy7315_poe_p1_v1.Admin_Fragments.GenerateReportFragment
import com.example.insy7315_poe_p1_v1.Admin_Fragments.HomeFragment
import com.example.insy7315_poe_p1_v1.Admin_Fragments.ManageUsersFragment
import com.example.insy7315_poe_p1_v1.FragmentsForAll.ProfileFragment
import com.example.insy7315_poe_p1_v1.FragmentsForAll.UsersListFragment

class Admin_Home : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_home)

        drawerLayout = findViewById(R.id.drawerLayout)
//        val btnMenu = findViewById<Button>(R.id.btnMenu)
        val smDashboard = findViewById<TextView>(R.id.smDashboard)
        val smManageUsers = findViewById<TextView>(R.id.smManageUsers)
        val smReports = findViewById<TextView>(R.id.smReports)
        val smCommunication = findViewById<TextView>(R.id.smCommunication)
        val smAiEscalations = findViewById<TextView>(R.id.smAiEscalations)
        val smProfile = findViewById<TextView>(R.id.smProfile)

        // Handle system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawerLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Open drawer on button click
//        btnMenu.setOnClickListener {
//            drawerLayout.openDrawer(GravityCompat.START)
//        }

        // Drawer menu item click listeners
        smAiEscalations.setOnClickListener {
            replaceFragment(EscalationsFragment())
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        smCommunication.setOnClickListener {
            replaceFragment(UsersListFragment())
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        smDashboard.setOnClickListener {
            replaceFragment(HomeFragment())
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        smManageUsers.setOnClickListener {
            replaceFragment(ManageUsersFragment())
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        smProfile.setOnClickListener {
            replaceFragment(ProfileFragment())
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        smReports.setOnClickListener {
            replaceFragment(GenerateReportFragment())
            drawerLayout.closeDrawer(GravityCompat.START)
        }


        // Load default fragment
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }
}
