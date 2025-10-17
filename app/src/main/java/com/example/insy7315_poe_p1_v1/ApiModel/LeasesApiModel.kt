package com.example.insy7315_poe_p1_v1.ApiModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date
@Parcelize
data class LeasesApiModel (
    @SerializedName("id")
    val leaseID: String,
    val deposit: Int,
    val startDate: Date,
    val endDate: Date,
    val status: String,
    val tenantID: String,
    val propertyID: String,
    val unitID: String
) : Parcelable