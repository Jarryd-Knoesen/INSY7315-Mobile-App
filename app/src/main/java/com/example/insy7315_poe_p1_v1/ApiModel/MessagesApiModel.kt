package com.example.insy7315_poe_p1_v1.ApiModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date
@Parcelize
data class MessagesApiModel (
    @SerializedName("id")
    val messageID: String,
    val createdAt: Date,
    val message: String,
    val senderID: String,
    val receiverID: String
) : Parcelable