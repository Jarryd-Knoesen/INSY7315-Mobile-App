package com.example.insy7315_poe_p1_v1.Models

import java.util.*

object MaintenanceRequestRepository {
    val maintenanceRequests: MutableList<MaintenanceRequestModel> = mutableListOf(
        MaintenanceRequestModel(
            "1",
            "Kaylee",
            "B5",
            "Toilet leaking",
            "The toilet in the house is leaking",
            getDate(2025, 8, 10),
            getDate(2025, 7, 30),
            "Marco",
            "In Progress"
        ),
        MaintenanceRequestModel(
            "2",
            "Liam",
            "C11",
            "Broken window",
            "The living room window is cracked and won’t close properly",
            getDate(2025, 7, 28),
            getDate(2025, 7, 30),
            "Sophia",
            "Pending"
        ),
        MaintenanceRequestModel(
            "3",
            "Aisha",
            "B21",
            "Power outage",
            "No electricity in the kitchen and living area since last night",
            getDate(2025, 8, 5),
            getDate(2025, 7, 30),
            "Daniel",
            "In Progress"
        ),

        MaintenanceRequestModel(
            "4",
            "Thabo",
            "A2",
            "Clogged sink",
            "The kitchen sink is clogged and water won’t drain",
            getDate(2025, 8, 12),
            getDate(2025, 7, 30),
            "Marco",
            "Completed"
        ),

        MaintenanceRequestModel(
            "5",
            "Naledi",
            "A25",
            "Broken door lock",
            "Front door lock is jammed and difficult to open",
            getDate(2025, 8, 15),
            getDate(2025, 7, 30),
            "Sophia",
            "Pending"
        ),

        MaintenanceRequestModel(
            "6",
            "Ethan",
            "B5",
            "Leaking roof",
            "Water dripping from the roof during heavy rain",
            getDate(2025, 7, 30),
            getDate(2025, 7, 30),
            "Daniel",
            "In Progress"
        ),

        MaintenanceRequestModel(
            "7",
            "Amara",
            "B5",
            "Air conditioner not working",
            "The air conditioner won’t turn on despite multiple attempts",
            getDate(2025, 8, 1),
            getDate(2025, 7, 30),
            "Marco",
            "Completed"
        ),

            MaintenanceRequestModel(
            "8",
            "Sipho",
                "B5",
            "Broken light fixture",
            "Ceiling light in the bedroom keeps flickering and making noise",
            getDate(2025, 8, 18),
                getDate(2025, 7, 30),
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