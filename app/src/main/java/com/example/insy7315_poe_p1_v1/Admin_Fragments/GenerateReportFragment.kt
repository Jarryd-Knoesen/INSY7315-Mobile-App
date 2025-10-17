package com.example.insy7315_poe_p1_v1.Admin_Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.R
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

// ReportController
// There is a function to get the necessary data for the report
// will display it on the viewReportFragment fragment
// Data needed:
// uid

// remove the data selection for now !!!!!!!!!!
class GenerateReportFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_fragment_create_report, container, false)

        val btnGenerateReport = view.findViewById<Button>(R.id.btnGenerateReport)

        btnGenerateReport.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ViewReportFragment())
                .addToBackStack(null)
                .commit()

            (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        return view
    }
}