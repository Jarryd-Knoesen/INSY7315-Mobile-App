package com.example.insy7315_poe_p1_v1.Manager_Fregments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Adapters.MaintenanceTasksManagerViewAdapter
import com.example.insy7315_poe_p1_v1.Models.MaintenanceRequestModel
import com.example.insy7315_poe_p1_v1.Models.MaintenanceRequestRepository

class MaintenanceOverview : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MaintenanceTasksManagerViewAdapter
    private lateinit var searchText: EditText
    // This list holds the original, unfiltered and unsorted data.
    private val taskList: List<MaintenanceRequestModel> by lazy {
        MaintenanceRequestRepository.maintenanceRequests
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.manager_fragment_maintenance_tasks, container, false)

        searchText = view.findViewById(R.id.etFilterSearch)
        recyclerView = view.findViewById(R.id.taskManagerMaintenanceTasksRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initial sorted list for the adapter
        val initialSortedList = taskList.sortedBy { it.issueDate }
        adapter = MaintenanceTasksManagerViewAdapter(initialSortedList)
        recyclerView.adapter = adapter

        // Setup sorting headers
        setupSortHeader(view.findViewById(R.id.unit_header)) { it.unit }
        setupSortHeader(view.findViewById(R.id.status_header)) { it.status }
        setupSortHeader(view.findViewById(R.id.reported_date_header)) { it.issueDate }
        setupSortHeader(view.findViewById(R.id.issue_header)) { it.issue }

        searchText.addTextChangedListener { query ->
            // Always filter from the original, complete list of tasks.
            val filteredList = taskList.filter { task ->
                task.unit.contains(query.toString(), ignoreCase = true) ||
                        task.status.contains(query.toString(), ignoreCase = true) ||
                        task.issueDate.toString().contains(query.toString(), ignoreCase = true) ||
                        task.issue.contains(query.toString(), ignoreCase = true)
            }
            // The adapter's update method will handle displaying the new list.
            adapter.updateList(filteredList)
        }

        return view
    }

    private fun <T : Comparable<T>> setupSortHeader(
        headerView: TextView,
        selector: (MaintenanceRequestModel) -> T
    ) {
        var ascending = true
        headerView.setOnClickListener {
            // Get the current list directly from the adapter to sort it.
            val currentList = adapter.getItems()
            val sorted = if (ascending) {
                currentList.sortedBy(selector)
            } else {
                currentList.sortedByDescending(selector)
            }
            ascending = !ascending
            adapter.updateList(sorted)
        }
    }
}
