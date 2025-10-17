package com.example.insy7315_poe_p1_v1.Admin_Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Adapters.ManageUsersAdapter
import com.example.insy7315_poe_p1_v1.Models.UsersModel
import com.example.insy7315_poe_p1_v1.Models.UsersRepository
import com.example.insy7315_poe_p1_v1.R

// UsersController
// There is a function to get all the users to be displayed
// the admin is removed from the list of users
// Data needed:
// uid
class ManageUsersFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ManageUsersAdapter
    private lateinit var manageUsersList: List<UsersModel>

    private lateinit var searchText : EditText

    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_fragment_manage_users, container, false)

        // Filter ID
        searchText = view.findViewById(R.id.etFilterSearch)

        recyclerView = view.findViewById(R.id.taskAdminManageUsersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Example Data
        manageUsersList = UsersRepository.users
        adapter = ManageUsersAdapter(manageUsersList)
        recyclerView.adapter = adapter

        // Add search listener
        searchText.addTextChangedListener { query ->
            val filteredList = manageUsersList.filter { user ->
                user.name.contains(query.toString(), ignoreCase = true) ||
                        user.email.contains(query.toString(), ignoreCase = true) ||
                        user.userType.contains(query.toString(), ignoreCase = true) ||
                        user.located.contains(query.toString(), ignoreCase = true) ||
                        user.status.contains(query.toString(), ignoreCase = true)
            }
            adapter.updateList(filteredList)
        }

        return view
    }
}

