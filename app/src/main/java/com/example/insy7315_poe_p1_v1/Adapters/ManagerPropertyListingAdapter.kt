package com.example.insy7315_poe_p1_v1.Adapters

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Models.PropertiesModel
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.insy7315_poe_p1_v1.Models.PropertiesRepository.propertyList
import com.example.insy7315_poe_p1_v1.R

class ManagerPropertyListingAdapter (private var properties: List<PropertiesModel>) :
RecyclerView.Adapter<ManagerPropertyListingAdapter.PropertyViewHolder>() {

    inner class PropertyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val propertyName: TextView = itemView.findViewById(R.id.property_name)
        val unitNumber: TextView = itemView.findViewById(R.id.unit_number)
        val rooms: TextView = itemView.findViewById(R.id.rooms)
        val rentAmount: TextView = itemView.findViewById(R.id.rent_amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): PropertyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_manager_property_listing, parent, false)
        return PropertyViewHolder(view)
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        val property = properties[position]
        holder.propertyName.text = property.propertyName
        holder.unitNumber.text = "Unit: ${property.unitNumber}"
        holder.rooms.text = "Rooms: ${property.rooms}"
        holder.rentAmount.text = "Rent: $${property.rentAmount}"
    }

    fun updateList(newList: List<PropertiesModel>) {
        properties = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = properties.size
}