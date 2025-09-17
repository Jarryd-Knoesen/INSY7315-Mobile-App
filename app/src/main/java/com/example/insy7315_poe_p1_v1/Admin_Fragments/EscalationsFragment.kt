package com.example.insy7315_poe_p1_v1.Admin_Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Adapters.EscalationsAdapter
import com.example.insy7315_poe_p1_v1.Models.EscalationsModel
import com.example.insy7315_poe_p1_v1.Models.EscalationsRepository
import com.example.insy7315_poe_p1_v1.R

class EscalationsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EscalationsAdapter
    private lateinit var escalationList: List<EscalationsModel>

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_fragment_ai_escalations, container, false)

        recyclerView = view.findViewById(R.id.taskEscalationsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Example Data
        escalationList = EscalationsRepository.escalations
        adapter = EscalationsAdapter(escalationList)
        recyclerView.adapter = adapter

        return view
    }
}