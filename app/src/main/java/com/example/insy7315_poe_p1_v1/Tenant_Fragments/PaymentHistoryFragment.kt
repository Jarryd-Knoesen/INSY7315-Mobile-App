package com.example.insy7315_poe_p1_v1.Tenant_Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.R
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PaymentHistoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.tenant_fragment_payment_history, container, false)

        // Set button click listener
        val btnMakePayment = view.findViewById<Button>(R.id.btnMakePayment)

        btnMakePayment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MakePaymentFragment())
                .addToBackStack(null) // Lets the user press back to return here
                .commit()

            (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        return view
    }
}
