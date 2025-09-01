package com.example.insy7315_poe_p1_v1.Models

import java.util.*

object PaymentRepository {
    val payments: MutableList<PaymentModel> = mutableListOf(
        PaymentModel(
            "1",
            "Jackie",
            "1500",
            getDate(2025,8,12),
            "A1",
            "Paid",
        ),
        PaymentModel(
            "2",
            "Liam",
            "2200",
            getDate(2025, 8, 10),
            "A2",
            "Pending",
        ),

        PaymentModel(
            "3",
            "Aisha",
            "1800",
            getDate(2025, 8, 8),
            "B1",
            "Paid",
        ),

        PaymentModel(
            "4",
            "Thabo",
            "2000",
            getDate(2025, 8, 5),
            "B2",
            "Overdue",
        ),

        PaymentModel(
            "5",
            "Naledi",
            "2500",
            getDate(2025, 7, 30),
            "C1",
            "Paid",
        ),

        PaymentModel(
            "6",
            "Ethan",
            "1700",
            getDate(2025, 8, 15),
            "C2",
            "Pending",
        ),

        PaymentModel(
            "7",
            "Amara",
            "2100",
            getDate(2025, 8, 18),
            "D1",
            "Paid",
        ),

        PaymentModel(
            "8",
            "Sipho",
            "1900",
            getDate(2025, 8, 20),
            "D2",
            "Overdue",
        )

    )

    private fun getDate(year: Int, month: Int, day: Int): Date {
        return Calendar.getInstance().apply {
            set(year, month - 1, day, 0, 0, 0)
            set(Calendar.MILLISECOND, 0)
        }.time
    }
}