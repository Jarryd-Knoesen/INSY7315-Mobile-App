package com.example.insy7315_poe_p1_v1.ApiModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date
@Parcelize
data class PropertiesApiModel (
    @SerializedName("id")
    val propertiesID: String,
    val name: String,
    val address: String,
    val amenities: List<String>,
    val status: String,
    val createdAt: Date
) : Parcelable