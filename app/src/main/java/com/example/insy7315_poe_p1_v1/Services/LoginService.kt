package com.example.insy7315_poe_p1_v1.Services

import android.util.Log
import com.example.insy7315_poe_p1_v1.Models.UsersModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

object LoginService {
    private val dataBase = Firebase.firestore

    // Check if user exists
    fun authenticateUser(
        email: String,
        password: String,
        onResult: (UsersModel?) -> Unit
    ) {
        dataBase.collection("users")
            .whereEqualTo("email", email)
            .whereEqualTo("password", password)
            .get()
            .addOnSuccessListener { result ->
                if (!result.isEmpty) {
                    val doc = result.documents[0]
                    val user = UsersModel(
                        name = doc.getString("name") ?: "",
                        email = doc.getString("email") ?: "",
                        password = doc.getString("password") ?: "",
                        userType = doc.getString("userType") ?: "",
                        located = doc.getString("located") ?: "",
                        status = doc.getString("status") ?: "",
                        id = doc.id
                    )
                    onResult(user)
                } else {
                    onResult(null)
                }
            }
            .addOnFailureListener { e ->
                Log.e("LoginService", "Authentication failed", e)
                onResult(null)
            }
    }
}