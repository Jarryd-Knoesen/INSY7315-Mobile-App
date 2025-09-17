package com.example.insy7315_poe_p1_v1.Tenant_Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.R

class PropertyListingsFragment : Fragment() {
    override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    val view = inflater.inflate(R.layout.tenant_fragment_property_listings, container, false)

    val btnBack = view.findViewById<Button>(R.id.btnBack)

    btnBack.setOnClickListener {
        parentFragmentManager.popBackStack()
    }

    return view
}
}