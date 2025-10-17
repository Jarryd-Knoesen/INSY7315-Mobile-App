package com.example.insy7315_poe_p1_v1.ApiModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UnitsApiModel (
    @SerializedName("id")
    val unitsID: String,
    val isAvailable: Boolean,
    val leaseID: String,
    val rentAmount: Int,
    val tenantID: String,
    val unitNumber: String
) : Parcelable