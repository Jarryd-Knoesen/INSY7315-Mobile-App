package com.example.insy7315_poe_p1_v1.Admin_Fragments

import android.annotation.SuppressLint
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
import com.example.insy7315_poe_p1_v1.Adapters.EscalationsAdapter
import com.example.insy7315_poe_p1_v1.Models.EscalationsModel
import com.example.insy7315_poe_p1_v1.Models.EscalationsRepository
import com.example.insy7315_poe_p1_v1.R

// AiEscalationController
// There is a function to get the escalation data
// Data needed:
// uid
class EscalationsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EscalationsAdapter
    private lateinit var escalationList: List<EscalationsModel>

    private lateinit var searchText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_fragment_ai_escalations, container, false)

        // Filter ID
        searchText = view.findViewById(R.id.etFilterSearch)

        recyclerView = view.findViewById(R.id.taskEscalationsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Example Data
        escalationList = EscalationsRepository.escalations
        adapter = EscalationsAdapter(escalationList)
        recyclerView.adapter = adapter

        // Setup sorting headers
        setupSortHeader(view.findViewById(R.id.header_id)) { it.escalationID }
        setupSortHeader(view.findViewById(R.id.header_date)) { it.dateTime }
        setupSortHeader(view.findViewById(R.id.header_person)) { it.person }
        setupSortHeader(view.findViewById(R.id.header_category)) { it.category }
        setupSortHeader(view.findViewById(R.id.header_status)) { it.status }
        setupSortHeader(view.findViewById(R.id.header_priority)) { it.priority }

        searchText.addTextChangedListener { query ->
            val filteredList = escalationList.filter { escalation ->
                escalation.escalationID.contains(query.toString(), ignoreCase = true) ||
                escalation.dateTime.toString().contains(query.toString(), ignoreCase = true) ||
                escalation.person.contains(query.toString(), ignoreCase = true) ||
                escalation.category.contains(query.toString(), ignoreCase = true) ||
                escalation.status.contains(query.toString(), ignoreCase = true) ||
                escalation.priority.contains(query.toString(), ignoreCase = true)
            }
            adapter.updateSearchList(filteredList)
        }

        return view
    }

    private fun <T : Comparable<T>> setupSortHeader (
        headerView: TextView,
        selector: (EscalationsModel) -> T
    ) {
        var ascending = true
        headerView.setOnClickListener {
            val sorted = if ( ascending ) {
                escalationList.sortedBy(selector)
            } else {
                escalationList.sortedByDescending(selector)
            }
            ascending = !ascending
            adapter.updateList(sorted)
        }
    }
}