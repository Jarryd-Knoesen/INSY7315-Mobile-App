package com.example.insy7315_poe_p1_v1.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.insy7315_poe_p1_v1.Models.PaymentModel
import com.example.insy7315_poe_p1_v1.R
import java.text.SimpleDateFormat
import java.util.Locale


class PaymentsAdapter(private val payments: List<PaymentModel>) :
    RecyclerView.Adapter<PaymentsAdapter.PaymentsViewHolder>() {

    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    class PaymentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val amountTextView: TextView = itemView.findViewById(R.id.amount)
        val statusTextView: TextView = itemView.findViewById(R.id.status)
        val dateTextView: TextView = itemView.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): PaymentsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tenant_payment_history, parent, false)
        return PaymentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentsViewHolder, position: Int) {
        val request = payments[position]
        val amountFormated = "R " + request.amount
        holder.amountTextView.text = amountFormated
        holder.dateTextView.text = dateFormat.format(request.paymentDate)
        holder.statusTextView.text = request.status
    }

    override fun getItemCount(): Int = payments.size
}
