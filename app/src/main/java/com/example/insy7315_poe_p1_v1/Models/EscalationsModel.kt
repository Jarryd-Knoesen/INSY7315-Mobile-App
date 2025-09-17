package com.example.insy7315_poe_p1_v1.Models

import java.io.Serializable
import java.util.Date

data class EscalationsModel (
    val escalationID: String,
    val dateTime: Date,
    val source: String,
    val property: String,
    val category: String,
    val description: String,
    val reason: String,
    val status: String,
    val assignedTo: String,
    val priority: String,
    val actions: String
) : Serializable