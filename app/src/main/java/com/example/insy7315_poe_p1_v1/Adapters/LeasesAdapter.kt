package com.example.insy7315_poe_p1_v1.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Models.EscalationsModel
import com.example.insy7315_poe_p1_v1.Models.LeaseModel
import com.example.insy7315_poe_p1_v1.R
import java.text.SimpleDateFormat
import java.util.Locale

class LeasesAdapter (private var leasesList: List<LeaseModel>) :
RecyclerView.Adapter<LeasesAdapter.LeaseViewHolder>() {

    fun updateList (newList: List<LeaseModel>) {
        leasesList = newList.toMutableList()
        notifyDataSetChanged()
    }

    fun updateSearchList (newList: List<LeaseModel>) {
        leasesList = newList
        notifyDataSetChanged()
    }

    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    class LeaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val statusTextView: TextView = itemView.findViewById(R.id.status)
        val unitTextView: TextView = itemView.findViewById(R.id.unit)
        val tenantTextView: TextView = itemView.findViewById(R.id.tenant)
        val leaseStartTextView: TextView = itemView.findViewById(R.id.leaseStart)
        val leaseEndTextView: TextView = itemView.findViewById(R.id.leaseEnd)
        val rentAmountTextView: TextView = itemView.findViewById(R.id.rentAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int) : LeaseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_manager_lease_overview, parent, false)
        return LeaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeaseViewHolder, position: Int) {
        val lease = leasesList[position]
        holder.statusTextView.text = lease.status
        holder.unitTextView.text = lease.unit
        holder.tenantTextView.text = lease.tenant
        holder.leaseStartTextView.text = dateFormat.format(lease.leaseStart)
        holder.leaseEndTextView.text = dateFormat.format(lease.leaseEnd)
        holder.rentAmountTextView.text = lease.rentAmount
    }

    override fun getItemCount(): Int = leasesList.size

}