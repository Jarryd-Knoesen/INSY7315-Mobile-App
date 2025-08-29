package com.example.insy7315_poe_p1_v1.Tenant_Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.R
import android.widget.Button

class MakePaymentFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.tenant_fragment_make_payment, container, false)

        val btnBack = view.findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }
}
