package com.example.insy7315_poe_p1_v1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout

class Home : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawerLayout)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        // Gets ID of the menu button and the drawer layout
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val btnMenu = findViewById<Button>(R.id.btnMenu)

        val btnApplication = findViewById<TextView>(R.id.smApplications)
        val btnCommunication = findViewById<TextView>(R.id.smCommunication)
        val btnDashboard = findViewById<TextView>(R.id.smDashboard)
        val btnNotes = findViewById<TextView>(R.id.smNotes)
        val btnMaintenanceOverview = findViewById<TextView>(R.id.smMaintenanceOverview)
        val btnMaintenanceRequests = findViewById<TextView>(R.id.smMaintenanceRequests)
        val btnMaintenanceTasks = findViewById<TextView>(R.id.smMaintenanceTasks)
        val btnMyLease = findViewById<TextView>(R.id.smMyLease)
        val btnPaymentsPM = findViewById<TextView>(R.id.smPaymentsPM)
        val btnPaymentsTenant = findViewById<TextView>(R.id.smPaymentsTenant)
        val btnPropertiesPM = findViewById<TextView>(R.id.smPropertiesPM)
        val btnPropertiesAdmin = findViewById<TextView>(R.id.smPropertiesAdmin)
        val btnPropertyListingsTenant = findViewById<TextView>(R.id.smPropertyListingsTenant)
        val btnTenants = findViewById<TextView>(R.id.smTenants)
        val btnReports = findViewById<TextView>(R.id.smReports)


        // Opens the drawer when the menu button is clicked
        btnMenu.setOnClickListener {
            if (drawerLayout.isDrawerOpen(findViewById(R.id.menuLayout))) {
                drawerLayout.closeDrawer(findViewById(R.id.menuLayout))
            } else {
                drawerLayout.openDrawer(findViewById(R.id.menuLayout))
            }
        }

        val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
        val userType = sharedPref.getString("userType", "Guest")

        when (userType) {
            "Admin" -> {
                btnApplication.isEnabled = false // disables the button
                btnApplication.visibility = View.GONE // makes the button invisible

                btnMaintenanceOverview.isEnabled = true
                btnMaintenanceOverview.visibility = View.VISIBLE

                btnMaintenanceRequests.isEnabled = false
                btnMaintenanceRequests.visibility = View.GONE

                btnMaintenanceTasks.isEnabled = false
                btnMaintenanceTasks.visibility = View.GONE

                btnMyLease.isEnabled = false
                btnMyLease.visibility = View.GONE

                btnPaymentsPM.isEnabled = false
                btnPaymentsPM.visibility = View.GONE

                btnPaymentsTenant.isEnabled = false
                btnPaymentsTenant.visibility = View.GONE

                btnPropertiesPM.isEnabled = false
                btnPropertiesPM.visibility = View.GONE

                btnPropertiesAdmin.isEnabled = true
                btnPropertiesAdmin.visibility = View.VISIBLE

                btnPropertyListingsTenant.isEnabled = false
                btnPropertyListingsTenant.visibility = View.GONE

                btnTenants.isEnabled = false
                btnTenants.visibility = View.GONE

                btnReports.isEnabled = true
                btnReports.visibility = View.VISIBLE
            }
            "Manager" -> {
                btnApplication.isEnabled = true // disables the button
                btnApplication.visibility = View.VISIBLE // makes the button invisible

                // Resets the marginTop value of the button to 0
                val params = btnCommunication.layoutParams as ViewGroup.MarginLayoutParams
                params.topMargin = 0
                btnCommunication.layoutParams = params

                btnMaintenanceOverview.isEnabled = true
                btnMaintenanceOverview.visibility = View.VISIBLE

                btnMaintenanceRequests.isEnabled = false
                btnMaintenanceRequests.visibility = View.GONE

                btnMaintenanceTasks.isEnabled = false
                btnMaintenanceTasks.visibility = View.GONE

                btnMyLease.isEnabled = false
                btnMyLease.visibility = View.GONE

                btnPaymentsPM.isEnabled = true
                btnPaymentsPM.visibility = View.VISIBLE

                btnPaymentsTenant.isEnabled = false
                btnPaymentsTenant.visibility = View.GONE

                btnPropertiesPM.isEnabled = true
                btnPropertiesPM.visibility = View.VISIBLE

                btnPropertiesAdmin.isEnabled = false
                btnPropertiesAdmin.visibility = View.GONE

                btnPropertyListingsTenant.isEnabled = false
                btnPropertyListingsTenant.visibility = View.GONE

                btnTenants.isEnabled = true
                btnTenants.visibility = View.VISIBLE

                btnReports.isEnabled = false
                btnReports.visibility = View.GONE
            }
            "Caretaker" -> {
                btnApplication.isEnabled = false // disables the button
                btnApplication.visibility = View.GONE // makes the button invisible

                btnMaintenanceOverview.isEnabled = false
                btnMaintenanceOverview.visibility = View.GONE

                btnMaintenanceRequests.isEnabled = false
                btnMaintenanceRequests.visibility = View.GONE

                btnMaintenanceTasks.isEnabled = true
                btnMaintenanceTasks.visibility = View.VISIBLE

                btnMyLease.isEnabled = false
                btnMyLease.visibility = View.GONE

                btnPaymentsPM.isEnabled = false
                btnPaymentsPM.visibility = View.GONE

                btnPaymentsTenant.isEnabled = false
                btnPaymentsTenant.visibility = View.GONE

                btnPropertiesPM.isEnabled = false
                btnPropertiesPM.visibility = View.GONE

                btnPropertiesAdmin.isEnabled = false
                btnPropertiesAdmin.visibility = View.GONE

                btnPropertyListingsTenant.isEnabled = false
                btnPropertyListingsTenant.visibility = View.GONE

                btnTenants.isEnabled = false
                btnTenants.visibility = View.GONE

                btnReports.isEnabled = false
                btnReports.visibility = View.GONE
            }
            "Tenant" -> {
                btnApplication.isEnabled = false // disables the button
                btnApplication.visibility = View.GONE // makes the button invisible

                btnMaintenanceOverview.isEnabled = false
                btnMaintenanceOverview.visibility = View.GONE

                btnMaintenanceRequests.isEnabled = true
                btnMaintenanceRequests.visibility = View.VISIBLE

                btnMaintenanceTasks.isEnabled = false
                btnMaintenanceTasks.visibility = View.GONE

                btnMyLease.isEnabled = true
                btnMyLease.visibility = View.VISIBLE

                btnPaymentsPM.isEnabled = false
                btnPaymentsPM.visibility = View.GONE

                btnPaymentsTenant.isEnabled = true
                btnPaymentsTenant.visibility = View.VISIBLE

                btnPropertiesPM.isEnabled = false
                btnPropertiesPM.visibility = View.GONE

                btnPropertiesAdmin.isEnabled = false
                btnPropertiesAdmin.visibility = View.GONE

                btnPropertyListingsTenant.isEnabled = true
                btnPropertyListingsTenant.visibility = View.VISIBLE

                btnTenants.isEnabled = false
                btnTenants.visibility = View.GONE

                btnReports.isEnabled = false
                btnReports.visibility = View.GONE
            }
            "Guest" -> {
                btnApplication.isEnabled = true // disables the button
                btnApplication.visibility = View.VISIBLE // makes the button invisible

                btnMaintenanceOverview.isEnabled = true
                btnMaintenanceOverview.visibility = View.VISIBLE

                btnMaintenanceRequests.isEnabled = true
                btnMaintenanceRequests.visibility = View.VISIBLE

                btnMaintenanceTasks.isEnabled = true
                btnMaintenanceTasks.visibility = View.VISIBLE

                btnMyLease.isEnabled = true
                btnMyLease.visibility = View.VISIBLE

                btnPaymentsPM.isEnabled = true
                btnPaymentsPM.visibility = View.VISIBLE

                btnPaymentsTenant.isEnabled = true
                btnPaymentsTenant.visibility = View.VISIBLE

                btnPropertiesPM.isEnabled = true
                btnPropertiesPM.visibility = View.VISIBLE

                btnPropertiesAdmin.isEnabled = true
                btnPropertiesAdmin.visibility = View.VISIBLE

                btnPropertyListingsTenant.isEnabled = true
                btnPropertyListingsTenant.visibility = View.VISIBLE

                btnTenants.isEnabled = true
                btnTenants.visibility = View.VISIBLE

                btnReports.isEnabled = true
                btnReports.visibility = View.VISIBLE
            }
        }
    }
}