package com.example.insy7315_poe_p1_v1.Tenant_Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.R
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Adapters.MaintenanceRequestAdapter
import com.example.insy7315_poe_p1_v1.Models.MaintenanceRequestModel
import com.example.insy7315_poe_p1_v1.Models.MaintenanceRequestRepository

class MaintenanceHistoryFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MaintenanceRequestAdapter
    private lateinit var requestList: List<MaintenanceRequestModel>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout first
        val view = inflater.inflate(R.layout.tenant_fragment_maintenance_history, container, false)

        // Setup RecyclerView
        recyclerView = view.findViewById(R.id.taskMaintenanceRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Example data
        requestList = MaintenanceRequestRepository.maintenanceRequests
        adapter = MaintenanceRequestAdapter(requestList)
        recyclerView.adapter = adapter

        // Button setup
        val btnMakeRequest = view.findViewById<Button>(R.id.btnMakeRequest)
        btnMakeRequest.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MaintenanceFragment())
                .addToBackStack(null)
                .commit()

            (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        return view
    }
}
