package com.example.insy7315_poe_p1_v1.ApiModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date
@Parcelize
data class InvoicesApiModel (
    @SerializedName("id")
    val invoiceID: String,
    val amount: Int,
    val createdAt: Date?,
    val dueDate: Date?,
    val leaseID: String,
    val tenantID: String,
    val status: String
) : Parcelable