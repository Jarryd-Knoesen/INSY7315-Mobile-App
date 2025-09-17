package com.example.insy7315_poe_p1_v1.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Models.UsersModel
import com.example.insy7315_poe_p1_v1.R

class ManageUsersAdapter (private var manageUsers: List<UsersModel>) :
    RecyclerView.Adapter<ManageUsersAdapter.ManageUsersViewHolder>() {

        class ManageUsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nameTextView: TextView = itemView.findViewById(R.id.name)
            val emailTextView: TextView = itemView.findViewById(R.id.email)
            val roleTextView: TextView = itemView.findViewById(R.id.role)
            val locatedTextView: TextView = itemView.findViewById(R.id.located)
            val statusTextView: TextView = itemView.findViewById(R.id.status)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int) : ManageUsersViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_admin_manager_users_list, parent,false)
        return ManageUsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: ManageUsersViewHolder, position: Int) {
        val user = manageUsers[position]
        holder.nameTextView.text = user.name
        holder.emailTextView.text = user.email
        holder.roleTextView.text = user.userType
        holder.locatedTextView.text = user.located
        holder.statusTextView.text = user.status
    }

    override fun getItemCount(): Int = manageUsers.size

    // updating the list based on the search filter
    fun updateList(newList: List<UsersModel>){
        manageUsers = newList
        notifyDataSetChanged()
    }

}