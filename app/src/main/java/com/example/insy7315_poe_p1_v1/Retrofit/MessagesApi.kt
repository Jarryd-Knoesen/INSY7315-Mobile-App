package com.example.insy7315_poe_p1_v1.Retrofit

import com.example.insy7315_poe_p1_v1.ApiModel.MessagesApiModel
import retrofit2.Call
import retrofit2.http.*

interface MessagesApi {

    @GET("Messages")
    fun getAllMessages(): Call<List<MessagesApiModel>>

    @GET("Messages/{id}")
    fun getMessageById(@Path("id") id: String): Call<MessagesApiModel>

    @POST("Messages")
    fun createMessage(@Body message: MessagesApiModel): Call<Void>

    @PUT("Messages/{id}")
    fun updateMessage(@Path("id") id: String, @Body message: MessagesApiModel): Call<Void>

    @DELETE("Messages/{id}")
    fun deleteMessage(@Path("id") id: String): Call<Void>
}