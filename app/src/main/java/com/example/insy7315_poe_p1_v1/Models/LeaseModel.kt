package com.example.insy7315_poe_p1_v1.Models

import java.io.Serializable
import java.util.Date

class LeaseModel (
    val status: String,
    val unit: String,
    val tenant: String,
    val leaseStart: Date,
    val leaseEnd: Date,
    val rentAmount: String,
    val manager: String
) : Serializable