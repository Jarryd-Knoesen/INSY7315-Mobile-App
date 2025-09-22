package com.example.insy7315_poe_p1_v1.Adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Models.MaintenanceRequestModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.Locale
import com.example.insy7315_poe_p1_v1.R
import java.text.SimpleDateFormat

class MaintenanceTasksManagerViewAdapter (private var maintenanceTasks: List<MaintenanceRequestModel>) :
    RecyclerView.Adapter<MaintenanceTasksManagerViewAdapter.ManagerMaintenanceTasksViewHolder>() {

    fun updateList(newList: List<MaintenanceRequestModel>) {
        maintenanceTasks = newList.toMutableList()
        notifyDataSetChanged()
    }

    fun updateSearchList(newList: List<MaintenanceRequestModel>) {
        maintenanceTasks = newList
        notifyDataSetChanged()
    }

    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    class ManagerMaintenanceTasksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val unitTextView: TextView = itemView.findViewById(R.id.unit)
        val statusTextView: TextView = itemView.findViewById(R.id.status)
        val reportedDateTextView: TextView = itemView.findViewById(R.id.reported_date)
        val issueTextView: TextView = itemView.findViewById(R.id.issue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int) : ManagerMaintenanceTasksViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_manager_maintenance_tasks, parent, false)
        return ManagerMaintenanceTasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: ManagerMaintenanceTasksViewHolder, position: Int) {
        val task = maintenanceTasks[position]
        holder.unitTextView.text = task.unit
        holder.statusTextView.text = task.status
        holder.reportedDateTextView.text = dateFormat.format(task.issueDate)
        holder.issueTextView.text = task.issue
    }
    override fun getItemCount(): Int = maintenanceTasks.size
}