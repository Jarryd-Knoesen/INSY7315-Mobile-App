package com.example.insy7315_poe_p1_v1.ApiModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date
@Parcelize
data class ApplicationsApiModel (
    @SerializedName("id")
    val applicationID: String,
    val email: String,
    val name: String,
    val phone: String,
    val propertyID: String,
    val unitID: String,
    val status: String,
    val submittedAt: Date
) : Parcelable