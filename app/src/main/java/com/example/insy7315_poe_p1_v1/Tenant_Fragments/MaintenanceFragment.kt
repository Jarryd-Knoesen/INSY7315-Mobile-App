package com.example.insy7315_poe_p1_v1.Tenant_Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.R
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Adapters.MaintenanceRequestAdapter
import com.example.insy7315_poe_p1_v1.Models.MaintenanceRequestModel
import com.example.insy7315_poe_p1_v1.Models.MaintenanceRequestRepository

// maintenanceRequestController:
// There is a function to POST a request
// Data needed:
// uid, description, urgency, category
class MaintenanceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.tenant_fragment_maintenance, container, false)

        val btnBack = view.findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }
}
