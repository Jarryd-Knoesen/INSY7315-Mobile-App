package com.example.insy7315_poe_p1_v1.Manager_Fregments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Adapters.ManagerPropertyListingAdapter
import com.example.insy7315_poe_p1_v1.Models.PropertiesRepository
import com.example.insy7315_poe_p1_v1.Models.PropertiesModel
import com.example.insy7315_poe_p1_v1.R

class PropertyListing : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ManagerPropertyListingAdapter
    private lateinit var searchText: EditText

    // Keep the original list for filtering
    private val propertyList: List<PropertiesModel> by lazy {
        PropertiesRepository.propertyList
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.manager_fragment_property_listing, container, false)

        searchText = view.findViewById(R.id.etFilterSearch)
        recyclerView = view.findViewById(R.id.property_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Load the full list initially
        adapter = ManagerPropertyListingAdapter(propertyList)
        recyclerView.adapter = adapter

        // Set up filtering
        searchText.addTextChangedListener { query ->
            val filteredList = propertyList.filter { property ->
                property.propertyName.contains(query.toString(), ignoreCase = true) ||
                        property.unitNumber.contains(query.toString(), ignoreCase = true) ||
                        property.rooms.toString().contains(query.toString()) ||
                        property.rentAmount.toString().contains(query.toString())
            }
            adapter.updateList(filteredList)
        }

        return view
    }
}
