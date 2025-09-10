package com.example.insy7315_poe_p1_v1.Models

import java.io.Serializable
import java.util.Date

data class MaintenanceRequestModel (
    val maintenanceID: String,
    val tenantName: String,
    val unit: String,
    val issue: String,
    val description: String,
    val issueDate: Date,
    val fixDate: Date,
    val assignedTo: String,
    val status: String
) : Serializable