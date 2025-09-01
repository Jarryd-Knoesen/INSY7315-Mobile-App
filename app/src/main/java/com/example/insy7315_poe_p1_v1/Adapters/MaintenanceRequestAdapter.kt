package com.example.insy7315_poe_p1_v1.Adapters
import com.example.insy7315_poe_p1_v1.Models.MaintenanceRequestModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.R
import java.text.SimpleDateFormat
import java.util.Locale


class MaintenanceRequestAdapter(private val maintenanceRequests: List<MaintenanceRequestModel>) :
        RecyclerView.Adapter<MaintenanceRequestAdapter.MaintenanceRequestViewHolder>() {

    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    class MaintenanceRequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val issueTextView: TextView = itemView.findViewById(R.id.issue)
        val reportDateTextView: TextView = itemView.findViewById(R.id.reportDate)
        val statusTextView: TextView = itemView.findViewById(R.id.status)
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MaintenanceRequestViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tenant_maintenance_requests, parent, false)
        return MaintenanceRequestViewHolder(view)
    }

    override fun onBindViewHolder(holder: MaintenanceRequestViewHolder, position: Int) {
        val request = maintenanceRequests[position]
        holder.issueTextView.text = request.issue
        holder.reportDateTextView.text = dateFormat.format(request.issueDate)
        holder.statusTextView.text = request.status
    }

    override fun getItemCount(): Int = maintenanceRequests.size
}
