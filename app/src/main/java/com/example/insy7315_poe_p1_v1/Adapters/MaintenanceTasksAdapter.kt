package com.example.insy7315_poe_p1_v1.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Models.MaintenanceRequestModel
import java.util.Locale
import com.example.insy7315_poe_p1_v1.R
import java.text.SimpleDateFormat

class MaintenanceTasksAdapter(private val maintenanceTasks: List<MaintenanceRequestModel>) :
    RecyclerView.Adapter<MaintenanceTasksAdapter.MaintenanceTasksViewHolder>() {

    private val dateFormat = SimpleDateFormat("dd/MM/yyy", Locale.getDefault())

    class MaintenanceTasksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val unitTextView: TextView = itemView.findViewById(R.id.unit)
        val statusTextView: TextView = itemView.findViewById(R.id.status)
        val fixDateTextView: TextView = itemView.findViewById(R.id.fix_date)
        val issueTextView: TextView = itemView.findViewById(R.id.issue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int) : MaintenanceTasksViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_caretaker_tasks_list, parent, false)
        return MaintenanceTasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: MaintenanceTasksViewHolder, position: Int) {
        val task = maintenanceTasks[position]
        holder.unitTextView.text = task.unit
        holder.statusTextView.text = task.status
        holder.fixDateTextView.text = dateFormat.format(task.fixDate)
        holder.issueTextView.text = task.issue
    }

    override fun getItemCount(): Int = maintenanceTasks.size
}