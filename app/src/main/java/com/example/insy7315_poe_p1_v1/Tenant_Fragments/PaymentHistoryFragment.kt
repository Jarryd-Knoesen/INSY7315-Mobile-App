package com.example.insy7315_poe_p1_v1.Tenant_Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.R
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Adapters.MaintenanceRequestAdapter
import com.example.insy7315_poe_p1_v1.Adapters.PaymentsAdapter
import com.example.insy7315_poe_p1_v1.Models.MaintenanceRequestModel
import com.example.insy7315_poe_p1_v1.Models.PaymentModel
import com.example.insy7315_poe_p1_v1.Models.PaymentRepository

// InvoicesController
// There is a function to get the invoices linked to the user
// Data needed:
// uid
class PaymentHistoryFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PaymentsAdapter
    private lateinit var paymentsList: List<PaymentModel>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.tenant_fragment_payment_history, container, false)

        // Setup RecyclerView
        recyclerView = view.findViewById(R.id.taskPaymentsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Example data
        paymentsList = PaymentRepository.payments
        adapter = PaymentsAdapter(paymentsList)
        recyclerView.adapter = adapter

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
