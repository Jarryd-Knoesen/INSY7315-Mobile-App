package com.example.insy7315_poe_p1_v1.FragmentsForAll

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.R
import android.widget.TextView

// MessagesController
// There is a function to get the messages
// Get messages: will get the messages of the current user and the selected user

class MessagesFragment : Fragment() {

    private var userId: String? = null
    private var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userId = it.getString("userId")
            userName = it.getString("userName")
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.all_fragment_message_chat, container, false)

        val title = view.findViewById<TextView>(R.id.chatTitle)
        title.text = userName

        // Later the conversation messages will be loaded here

        return view
    }
}
