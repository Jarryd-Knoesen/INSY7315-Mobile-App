package com.example.insy7315_poe_p1_v1.Models
import java.io.Serializable

data class PropertiesModel (
    val propertyName: String,
    val unitNumber: String,
    val rooms: Int,
    val rentAmount: Double
) : Serializable