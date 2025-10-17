package com.example.insy7315_poe_p1_v1.Retrofit

import com.example.insy7315_poe_p1_v1.ApiModel.LeasesApiModel
import retrofit2.Call
import retrofit2.http.*

interface LeasesApi {

    @GET("Leases")
    fun getAllLeases(): Call<List<LeasesApiModel>>

    @GET("Leases/{id}")
    fun getLeaseById(@Path("id") id: String): Call<LeasesApiModel>

    @POST("Leases")
    fun createLease(@Body lease: LeasesApiModel): Call<Void>

    @PUT("Leases/{id}")
    fun updateLease(@Path("id") id: String, @Body lease: LeasesApiModel): Call<Void>

    @DELETE("Leases/{id}")
    fun deleteLease(@Path("id") id: String): Call<Void>
}