package com.example.insy7315_poe_p1_v1.Models

import java.io.Serializable
import java.util.Date

data class EscalationsModel (
    val escalationID: String,
    val dateTime: Date,
    val person: String,
    val category: String,
    val issue: String,
    val reason: String,
    val status: String,
    val priority: String,
    val actions: String
) : Serializable