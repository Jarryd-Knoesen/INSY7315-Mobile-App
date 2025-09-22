package com.example.insy7315_poe_p1_v1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.Admin_Fragments.EscalationsFragment
import com.example.insy7315_poe_p1_v1.FragmentsForAll.UsersListFragment
import com.example.insy7315_poe_p1_v1.Manager_Fregments.DashboardFragment
import com.example.insy7315_poe_p1_v1.Manager_Fregments.LeaseOverviewFragment
import com.example.insy7315_poe_p1_v1.Manager_Fregments.MaintenanceOverview

class Manager_Home : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_manager_home)

        drawerLayout = findViewById(R.id.drawerLayout)

        val smAiEscalations = findViewById<TextView>(R.id.smAiEscalations)
        val smCommunication = findViewById<TextView>(R.id.smCommunication)
        val smMainDashboard = findViewById<TextView>(R.id.smMainDashboard)
        val smLeaseOverview = findViewById<TextView>(R.id.smLeaseOverview)
        val smMaintenanceDashboard = findViewById<TextView>(R.id.smMaintenanceDashboard)
        val smPropertyListings = findViewById<TextView>(R.id.smPropertyListings)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawerLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        smAiEscalations.setOnClickListener {
            replaceFragment(EscalationsFragment())
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        smCommunication.setOnClickListener {
            replaceFragment(UsersListFragment())
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        smMainDashboard.setOnClickListener {
            replaceFragment(DashboardFragment())
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        smLeaseOverview.setOnClickListener {
            replaceFragment(LeaseOverviewFragment())
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        smMaintenanceDashboard.setOnClickListener {
            replaceFragment(MaintenanceOverview())
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        smPropertyListings.setOnClickListener {
            //replaceFragment()
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        if (savedInstanceState == null) {
            replaceFragment(DashboardFragment())
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