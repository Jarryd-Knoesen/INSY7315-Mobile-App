package com.example.insy7315_poe_p1_v1.Manager_Fregments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.R

// ManagerdashboardController
// There is a function to get the data to fill out the dashboard
// Data needed:
// uid
class DashboardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.manager_fragment_dashboard, container, false)
    }
}