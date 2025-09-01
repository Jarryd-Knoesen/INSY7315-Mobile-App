package com.example.insy7315_poe_p1_v1.Models

import java.util.*

object MaintenanceRequestRepository {
    val maintenanceRequests: MutableList<MaintenanceRequestModel> = mutableListOf(
        MaintenanceRequestModel(
            "1",
            "Kaylee",
            "Toilet leaking",
            "The toilet in the house is leaking",
            getDate(2025, 8, 10),
            "Marco",
            "In Progress"
        ),
        MaintenanceRequestModel(
            "2",
            "Liam",
            "Broken window",
            "The living room window is cracked and won’t close properly",
            getDate(2025, 7, 28),
            "Sophia",
            "Pending"
        ),
        MaintenanceRequestModel(
            "3",
            "Aisha",
            "Power outage",
            "No electricity in the kitchen and living area since last night",
            getDate(2025, 8, 5),
            "Daniel",
            "In Progress"
        ),

        MaintenanceRequestModel(
            "4",
            "Thabo",
            "Clogged sink",
            "The kitchen sink is clogged and water won’t drain",
            getDate(2025, 8, 12),
            "Marco",
            "Completed"
        ),

        MaintenanceRequestModel(
            "5",
            "Naledi",
            "Broken door lock",
            "Front door lock is jammed and difficult to open",
            getDate(2025, 8, 15),
            "Sophia",
            "Pending"
        ),

        MaintenanceRequestModel(
            "6",
            "Ethan",
            "Leaking roof",
            "Water dripping from the roof during heavy rain",
            getDate(2025, 7, 30),
            "Daniel",
            "In Progress"
        ),

        MaintenanceRequestModel(
            "7",
            "Amara",
            "Air conditioner not working",
            "The air conditioner won’t turn on despite multiple attempts",
            getDate(2025, 8, 1),
            "Marco",
            "Completed"
        ),

            MaintenanceRequestModel(
            "8",
            "Sipho",
            "Broken light fixture",
            "Ceiling light in the bedroom keeps flickering and making noise",
            getDate(2025, 8, 18),
            "Sophia",
            "Pending"
        )
    )

    private fun getDate(year: Int, month: Int, day: Int): Date {
        return Calendar.getInstance().apply {
            set(year, month - 1, day, 0, 0, 0)
            set(Calendar.MILLISECOND, 0)
        }.time
    }
}