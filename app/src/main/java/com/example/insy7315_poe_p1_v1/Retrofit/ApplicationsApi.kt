package com.example.insy7315_poe_p1_v1.Retrofit

import retrofit2.Call
import retrofit2.http.*
import com.example.insy7315_poe_p1_v1.ApiModel.ApplicationsApiModel

interface ApplicationsApi {

    @GET("Applications")
    fun getAllApplications(): Call<List<ApplicationsApiModel>>

    @GET("Applications/{id}")
    fun getApplicationById(@Path("id") id: String): Call<ApplicationsApiModel>

    @POST("Applications")
    fun createApplication(@Body application: ApplicationsApiModel): Call<Void>

    @PUT("Applications/{id}")
    fun updateApplication(@Path("id") id: String, @Body application: ApplicationsApiModel): Call<Void>

    @DELETE("Applications/{id}")
    fun deleteApplication(@Path("id") id: String): Call<Void>
}