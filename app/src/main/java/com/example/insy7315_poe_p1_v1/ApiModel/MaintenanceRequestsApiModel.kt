package com.example.insy7315_poe_p1_v1.ApiModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class MaintenanceRequestsApiModel(
    @SerializedName("id")
    val maintenanceRequestID: String,
    val assignedTo: String,
    val category: String,
    val createdAt: Date?,
    val description: String,
    val propertyID: String,
    val unitID: String,
    val tenantID: String,
    val status: String,
    val urgency: String
) : Parcelable
