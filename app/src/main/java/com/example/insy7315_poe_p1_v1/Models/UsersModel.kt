package com.example.insy7315_poe_p1_v1.Models
import java.io.Serializable

data class UsersModel (
    val id: String,
    val userType: String,
    val email: String,
    val password: String,
    val name: String
) : Serializable