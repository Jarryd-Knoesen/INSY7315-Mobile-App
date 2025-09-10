package com.example.insy7315_poe_p1_v1.FragmentsForAll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Adapters.UsersAdapter
import com.example.insy7315_poe_p1_v1.Models.UsersRepository
import com.example.insy7315_poe_p1_v1.R

class UsersListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.tenant_fragment_message_users, container, false)

        recyclerView = view.findViewById(R.id.taskUsersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = UsersAdapter(UsersRepository.users) { selectedUser ->
            // Navigate to ChatFragment with the selected user
            val bundle = Bundle()
            bundle.putString("userId", selectedUser.id)
            bundle.putString("userName", selectedUser.name)

            val messagesFragment = MessagesFragment()
            messagesFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, messagesFragment)
                .addToBackStack(null)
                .commit()

        }
        recyclerView.adapter = adapter

        return view
    }
}