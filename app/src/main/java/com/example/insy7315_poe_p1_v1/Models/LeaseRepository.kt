package com.example.insy7315_poe_p1_v1.Models

import java.util.*

object LeaseRepository {
    val leases: MutableList<LeaseModel> = mutableListOf(
        LeaseModel(
            status = "Active",
            unit = "A101",
            tenant = "John Smith",
            leaseStart = getDate(124, 0, 1),   // Jan 1, 2024
            leaseEnd = getDate(125, 0, 1),     // Jan 1, 2025
            rentAmount = "1200",
            manager = "Sarah Johnson"
        ),
        LeaseModel(
            status = "Active",
            unit = "B202",
            tenant = "Emily Davis",
            leaseStart = getDate(123, 6, 15),  // Jul 15, 2023
            leaseEnd = getDate(124, 6, 14),    // Jul 14, 2024
            rentAmount = "1450",
            manager = "Michael Lee"
        ),
        LeaseModel(
            status = "Pending",
            unit = "C303",
            tenant = "David Wilson",
            leaseStart = getDate(124, 2, 1),   // Mar 1, 2024
            leaseEnd = getDate(125, 1, 28),    // Feb 28, 2025
            rentAmount = "1350",
            manager = "Sarah Johnson"
        ),
        LeaseModel(
            status = "Active",
            unit = "D404",
            tenant = "Sophia Martinez",
            leaseStart = getDate(122, 10, 1),  // Nov 1, 2022
            leaseEnd = getDate(123, 10, 1),    // Nov 1, 2023
            rentAmount = "1600",
            manager = "Michael Lee"
        ),
        LeaseModel(
            status = "Expired",
            unit = "E505",
            tenant = "James Brown",
            leaseStart = getDate(121, 4, 15),  // May 15, 2021
            leaseEnd = getDate(122, 4, 14),    // May 14, 2022
            rentAmount = "1100",
            manager = "Karen Smith"
        ),
        LeaseModel(
            status = "Active",
            unit = "F606",
            tenant = "Olivia Garcia",
            leaseStart = getDate(124, 5, 1),   // Jun 1, 2024
            leaseEnd = getDate(125, 4, 31),    // May 31, 2025
            rentAmount = "1500",
            manager = "Sarah Johnson"
        ),
        LeaseModel(
            status = "Terminated",
            unit = "G707",
            tenant = "William Anderson",
            leaseStart = getDate(120, 7, 1),   // Aug 1, 2020
            leaseEnd = getDate(121, 7, 1),     // Aug 1, 2021
            rentAmount = "1000",
            manager = "Karen Smith"
        ),
        LeaseModel(
            status = "Active",
            unit = "H808",
            tenant = "Ava Martinez",
            leaseStart = getDate(124, 8, 1),   // Sep 1, 2024
            leaseEnd = getDate(125, 7, 31),    // Aug 31, 2025
            rentAmount = "1700",
            manager = "Michael Lee"
        ),
        LeaseModel(
            status = "Active",
            unit = "I909",
            tenant = "Liam Johnson",
            leaseStart = getDate(123, 11, 15), // Dec 15, 2023
            leaseEnd = getDate(124, 11, 14),   // Dec 14, 2024
            rentAmount = "1400",
            manager = "Sarah Johnson"
        ),
        LeaseModel(
            status = "Pending",
            unit = "J1010",
            tenant = "Mia Thompson",
            leaseStart = getDate(124, 3, 1),   // Apr 1, 2024
            leaseEnd = getDate(125, 2, 31),    // Mar 31, 2025
            rentAmount = "1550",
            manager = "Michael Lee"
        )
    )

    // Helper if you ever want to generate Date objects for time-based fields
    private fun getDate(year: Int, month: Int, day: Int): Date {
        return Calendar.getInstance().apply {
            set(year, month - 1, day)
            set(Calendar.MILLISECOND, 0)
        }.time
    }
}