package com.example.insy7315_poe_p1_v1.Caretaker_Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Adapters.MaintenanceTasksAdapter
import com.example.insy7315_poe_p1_v1.Models.MaintenanceRequestModel
import com.example.insy7315_poe_p1_v1.Models.MaintenanceRequestRepository

// maintenanceRequestController:
// There is a function to get the requests based on user role
// Data needed:
// uid

class TasksFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MaintenanceTasksAdapter
    private lateinit var taskList: List<MaintenanceRequestModel>

    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout first
        val view = inflater.inflate(R.layout.caretaker_fragment_tasks_list, container, false)

        // Setup RecyclerView
        recyclerView = view.findViewById(R.id.taskCaretakerTasksRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Example data
        taskList = MaintenanceRequestRepository.maintenanceRequests
        adapter = MaintenanceTasksAdapter(taskList)
        recyclerView.adapter = adapter

        // Button setup
            // This will be to update the tasks
            // Probably going to make a pop up to view the full details of the task
            // and a button to update the task

        return view
    }
}