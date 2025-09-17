package com.example.insy7315_poe_p1_v1.Models

import java.util.*

object EscalationsRepository {
    val escalations: MutableList<EscalationsModel> = mutableListOf(
        EscalationsModel(
            "ESC001",
            getDate(2025, 9, 1, 9, 15),
            "Tenant",
            "Blue Hills",
            "Rent/Payment",
            "Tenant unable to confirm rent payment via chatbot.",
            "Bot failed to verify proof of payment.",
            "Open",
            "Property Manager",
            "High",
            "Awaiting payment verification"
        ),
        EscalationsModel(
            "ESC002",
            getDate(2025, 9, 1, 11, 40),
            "Tenant",
            "Birchleigh",
            "Maintenance",
            "Leaking tap reported, bot could not assign caretaker.",
            "Chatbot escalation after 3 failed replies.",
            "In Progress",
            "Caretaker John",
            "Normal",
            "Caretaker assigned, awaiting update"
        ),
        EscalationsModel(
            "ESC003",
            getDate(2025, 9, 2, 8, 0),
            "AI System",
            "Florida",
            "Lease",
            "Lease expiring in 7 days, no renewal request logged.",
            "Automated escalation for expiring lease.",
            "Open",
            "Property Manager",
            "High",
            "Contact tenant for renewal decision"
        ),
        EscalationsModel(
            "ESC004",
            getDate(2025, 9, 2, 15, 20),
            "Tenant",
            "Blue Hills",
            "General Support",
            "Tenant asked about Wi-Fi setup, bot failed to answer.",
            "Unresolved chatbot query after 3 attempts.",
            "Resolved",
            "Admin",
            "Low",
            "Provided manual response via chat"
        ),
        EscalationsModel(
            "ESC005",
            getDate(2025, 9, 3, 10, 30),
            "Tenant",
            "Birchleigh",
            "Rent/Payment",
            "Tenant overdue by 14 days.",
            "System auto-escalation for arrears.",
            "Open",
            "Admin",
            "Critical",
            "Send final payment notice"
        ),
        EscalationsModel(
            "ESC006",
            getDate(2025, 9, 3, 16, 30),
            "Caretaker",
            "Florida",
            "Maintenance",
            "Caretaker reported missing spare parts for repair.",
            "Task escalation flagged as blocked.",
            "In Progress",
            "Property Manager",
            "Normal",
            "Escalation under review"
        ),
        EscalationsModel(
            "ESC007",
            getDate(2025, 9, 4, 12 ,0),
            "Tenant",
            "Blue Hills",
            "Maintenance",
            "Tenant submitted broken window report with photo, bot failed.",
            "Escalated due to unrecognized query.",
            "Open",
            "Caretaker Thabo",
            "High",
            "Pending caretaker visit"
        ),
        EscalationsModel(
            "ESC008",
            getDate(2025, 9, 5, 9, 45),
            "AI System",
            "Birchleigh",
            "Lease",
            "Tenant requested early termination of lease.",
            "Bot flagged non-standard request.",
            "In Progress",
            "Property Manager",
            "High",
            "Review lease terms"
        ),
        EscalationsModel(
            "ESC009",
            getDate(2025, 9, 5, 15, 30),
            "Tenant",
            "Florida",
            "General Support",
            "Tenant asked for copy of signed lease, bot could not retrieve.",
            "Escalated after data access error.",
            "Resolved",
            "Admin",
            "Low",
            "Lease PDF emailed to tenant"
        ),
        EscalationsModel(
            "ESC010",
            getDate(2025, 9, 6, 11, 15),
            "AI System",
            "Blue Hills",
            "Rent/Payment",
            "Payment upload failed sync offline → cloud.",
            "Auto-escalation from sync error.",
            "Open",
            "Admin",
            "High",
            "Retry sync or request re-upload"
        )
    )

    // Helper if you ever want to generate Date objects for time-based fields
    private fun getDate(year: Int, month: Int, day: Int, hour: Int, minute: Int): Date {
        return Calendar.getInstance().apply {
            set(year, month - 1, day, hour, minute, 0)
            set(Calendar.MILLISECOND, 0)
        }.time
    }
}
