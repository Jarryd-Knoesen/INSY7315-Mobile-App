package com.example.insy7315_poe_p1_v1.Retrofit

import com.example.insy7315_poe_p1_v1.ApiModel.UsersApiModel
import retrofit2.Call
import retrofit2.http.*

interface UsersApi {

    @GET("Users")
    fun getAllUsers(): Call<List<UsersApiModel>>

    @GET("Users/{id}")
    fun getUserById(@Path("id") id: String): Call<UsersApiModel>

    @POST("Users")
    fun createUser(@Body user: UsersApiModel): Call<Void>

    @PUT("Users/{id}")
    fun updateUser(@Path("id") id: String, @Body user: UsersApiModel): Call<Void>

    @DELETE("Users/{id}")
    fun deleteUser(@Path("id") id: String): Call<Void>
}