package com.example.insy7315_poe_p1_v1.Manager_Fregments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Adapters.LeasesAdapter
import com.example.insy7315_poe_p1_v1.Models.EscalationsModel
import com.example.insy7315_poe_p1_v1.Models.LeaseModel
import com.example.insy7315_poe_p1_v1.Models.LeaseRepository
import com.example.insy7315_poe_p1_v1.R

// LeaseController
// There is a function to get the leases
// Data needed:
// uid
class LeaseOverviewFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LeasesAdapter
    private lateinit var leasesList: List<LeaseModel>
    private lateinit var searchText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.manager_fragment_lease_overview, container, false)

        // Filter ID
        searchText = view.findViewById(R.id.etFilterSearch)

        recyclerView = view.findViewById(R.id.taskLeaseOverviewRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Example Data
        leasesList = LeaseRepository.leases
        adapter = LeasesAdapter(leasesList)
        recyclerView.adapter = adapter

        // Setup sorting headers
        setupSortHeader(view.findViewById(R.id.header_status)) { it.status }
        setupSortHeader(view.findViewById(R.id.header_id)) { it.unit }
        setupSortHeader(view.findViewById(R.id.header_date)) { it.tenant }
        setupSortHeader(view.findViewById(R.id.header_source)) { it.leaseStart }
        setupSortHeader(view.findViewById(R.id.header_property)) { it.leaseEnd }
        setupSortHeader(view.findViewById(R.id.header_category)) { it.rentAmount }

        searchText.addTextChangedListener { query ->
            val filteredList = leasesList.filter { lease ->
                lease.status.contains(query.toString(), ignoreCase = true) ||
                        lease.unit.contains(query.toString(), ignoreCase = true) ||
                        lease.tenant.contains(query.toString(), ignoreCase = true) ||
                        lease.leaseStart.toString().contains(query.toString(), ignoreCase = true) ||
                        lease.leaseEnd.toString().contains(query.toString(), ignoreCase = true) ||
                        lease.rentAmount.contains(query.toString(), ignoreCase = true)
            }
            adapter.updateSearchList(filteredList)

        }
        return view
    }

    private fun <T : Comparable<T>> setupSortHeader (
        headerView: TextView,
        selector: (LeaseModel) -> T
    ) {
        var ascending = true
        headerView.setOnClickListener {
            val sorted = if ( ascending ) {
                leasesList.sortedBy(selector)
            } else {
                leasesList.sortedByDescending(selector)
            }
            ascending = !ascending
            adapter.updateList(sorted)
        }
    }
}