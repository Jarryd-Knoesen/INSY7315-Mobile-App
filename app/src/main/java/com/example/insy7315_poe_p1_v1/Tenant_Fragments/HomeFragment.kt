package com.example.insy7315_poe_p1_v1.Tenant_Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.R
import com.example.insy7315_poe_p1_v1.Retrofit.ApiClient
import com.example.insy7315_poe_p1_v1.Retrofit.InvoicesApi
import com.example.insy7315_poe_p1_v1.Retrofit.UsersApi
import com.example.insy7315_poe_p1_v1.ApiModel.InvoicesApiModel
import com.example.insy7315_poe_p1_v1.ApiModel.UsersApiModel
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

// TenantDashboardController
// There is a function to get the data for the dashboard
// Data needed:
// uid
class HomeFragment : Fragment() {

    private var invoicesList: MutableList<InvoicesApiModel> = mutableListOf()
    private var userList: MutableList<UsersApiModel> = mutableListOf()

    private lateinit var overdueText: TextView
    private lateinit var overdueAmountText: TextView
    private lateinit var overdueDateText: TextView

    private lateinit var userID: String

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.tenant_fragment_home, container, false)

        overdueText = view.findViewById(R.id.tvOverdue)
        overdueAmountText = view.findViewById(R.id.tvOverdueAmount)
        overdueDateText = view.findViewById(R.id.tvOverdueDate)

        loadUserData()

        return view
    }

    private fun loadUserData() {
        val currentUserId = FirebaseAuth.getInstance().currentUser?.uid

        if (currentUserId == null) {
            Log.e("HomeFragment", "Current user ID is null")
            return
        }

        val userApi = ApiClient.instance.create(UsersApi::class.java)
        val call = userApi.getUserById(currentUserId)

        call.enqueue(object : Callback<UsersApiModel> {
            override fun onResponse(
                call: Call<UsersApiModel>,
                response: Response<UsersApiModel>
            ) {
                if (response.isSuccessful) {
                    val user = response.body()
                    if (user != null) {
                        userID = user.email
                        loadFragmentData()
                    }
                } else {
                    Log.e("HomeFragment", "Error: ${response.code()}")
                }
            }

            override fun onFailure(
                call: Call<UsersApiModel?>,
                t: Throwable
            ) {
                Log.e("HomeFragment", "Error: ${t.message}")
            }
        })

    }

    private fun loadFragmentData() {
        val invoiceApi = ApiClient.instance.create(InvoicesApi::class.java)
        val call = invoiceApi.getAllInvoices()

        call.enqueue(object : Callback<List<InvoicesApiModel>> {
            override fun onResponse(
                call: Call<List<InvoicesApiModel>>,
                response: Response<List<InvoicesApiModel>>
            ) {
                if (response.isSuccessful) {
                    val invoices = response.body()
                    if (invoices != null) {
                        invoicesList.clear()

                        // 1. Filter invoices for the current tenant
                        val tenantInvoices = invoices.filter { it.tenantID == userID}
                        invoicesList.addAll(tenantInvoices)

                        Log.d("HomeFragment", "Invoices loaded for tenant (${userID}): ${invoicesList.size}")

                        checkOverdueInvoices()
                    }
                } else {
                    Log.e("HomeFragment", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<InvoicesApiModel>>, t: Throwable) {
                Log.e("HomeFragment", "Error: ${t.message}")
            }
        })
    }

    private fun checkOverdueInvoices() {
        val overdueInvoices = invoicesList.filter { it.status.equals("Overdue", ignoreCase = true) }

        if (overdueInvoices.isNotEmpty()) {
            // Example: Show first overdue invoice
            val firstOverdue = overdueInvoices[0]
            val sdf = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
            val dueDateFormatted = firstOverdue.dueDate?.let { sdf.format(it) } ?: "Unknown"


            overdueText.text = "Overdue"
            overdueAmountText.text = "R ${firstOverdue.amount}"
            overdueDateText.text = "$dueDateFormatted"
            overdueText.visibility = View.VISIBLE
        } else {
            overdueText.visibility = View.GONE
        }
    }
}
