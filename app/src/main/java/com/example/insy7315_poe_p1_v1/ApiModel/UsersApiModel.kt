package com.example.insy7315_poe_p1_v1.ApiModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class UsersApiModel (
    @SerializedName("id")
    val userID: String,
    val email: String,
    val password: String,
    val phoneNumber: String,
    val name: String,
    val located: String,
    val status: String,
    val userType: String,
    val preferences: Map<String, String>,
    val createdAt: Date
) : Parcelable