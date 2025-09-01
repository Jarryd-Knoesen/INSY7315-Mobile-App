package com.example.insy7315_poe_p1_v1.Models

import java.io.Serializable
import java.util.Date

data class PaymentModel (
    val paymentID: String,
    val tenantName: String,
    val amount: String,
    val paymentDate: Date,
    val unit: String,
    val status: String
) : Serializable