package com.example.insy7315_poe_p1_v1.Tenant_Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.insy7315_poe_p1_v1.R
import androidx.appcompat.widget.SwitchCompat

class SettingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.tenant_fragment_settings, container, false)

        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val swDarkMode = view.findViewById<SwitchCompat>(R.id.swDarkMode)

        btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // Restore saved preference
        val sharedPref = requireActivity().getSharedPreferences("AppSettings", 0)
        val isDarkMode = sharedPref.getBoolean("DarkMode", false)
        swDarkMode.setOnCheckedChangeListener(null)
        swDarkMode.isChecked = isDarkMode

        swDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Enable dark mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                saveThemePreference(true)
            } else {
                // Disable dark mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                saveThemePreference(false)
            }
        }
        return view
    }

    private fun saveThemePreference(isDarkMode: Boolean) {
        val sharedPref = requireActivity().getSharedPreferences("AppSettings", 0)
        with(sharedPref.edit()) {
            putBoolean("DarkMode", isDarkMode)
            apply()
        }
    }
}