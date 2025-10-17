package com.example.insy7315_poe_p1_v1.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Models.EscalationsModel
import com.example.insy7315_poe_p1_v1.R
import java.text.SimpleDateFormat
import java.util.Locale

class EscalationsAdapter (private var escalationList: List<EscalationsModel>) :
RecyclerView.Adapter<EscalationsAdapter.EscalationViewHolder>() {

    fun updateList(newList: List<EscalationsModel>){
        escalationList  = newList.toMutableList()
        notifyDataSetChanged()
    }

    fun updateSearchList(newList: List<EscalationsModel>) {
        escalationList = newList
        notifyDataSetChanged()
    }

    private val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

    class EscalationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idTextView: TextView = itemView.findViewById(R.id.escalationID)
        val dateTextView: TextView = itemView.findViewById(R.id.date_time)
        val sourceTextView: TextView = itemView.findViewById(R.id.person)
        val categoryTextView: TextView = itemView.findViewById(R.id.category)
        val issueTextView: TextView = itemView.findViewById(R.id.issue)
        val statusTextView: TextView = itemView.findViewById(R.id.status)
        val priorityTextView: TextView = itemView.findViewById(R.id.priority)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int) : EscalationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_admin_ai_escalations_list, parent, false)
        return EscalationViewHolder(view)
    }

    override fun onBindViewHolder(holder: EscalationViewHolder, position: Int) {
        val escalation = escalationList[position]
        holder.idTextView.text = escalation.escalationID
        holder.dateTextView.text = dateFormat.format(escalation.dateTime)
        holder.sourceTextView.text = escalation.source
        holder.categoryTextView.text = escalation.category
        holder.issueTextView.text = escalation.issue
        holder.statusTextView.text = escalation.status
        holder.priorityTextView.text = escalation.priority
    }

    override fun getItemCount(): Int = escalationList.size
}