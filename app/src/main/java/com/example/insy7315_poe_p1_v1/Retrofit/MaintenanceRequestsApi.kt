package com.example.insy7315_poe_p1_v1.Retrofit

import com.example.insy7315_poe_p1_v1.ApiModel.MaintenanceRequestsApiModel
import retrofit2.Call
import retrofit2.http.*

interface MaintenanceRequestsApi {

    @GET("MaintenanceRequests")
    fun getAllMaintenanceRequests(): Call<List<MaintenanceRequestsApiModel>>

    @GET("MaintenanceRequests/{id}")
    fun getMaintenanceRequestById(@Path("id") id: String): Call<MaintenanceRequestsApiModel>

    @POST("MaintenanceRequests")
    fun createMaintenanceRequests(@Body maintenanceRequest: MaintenanceRequestsApiModel): Call<Void>

    @PUT("MaintenanceRequests/{id}")
    fun updateMaintenanceRequest(@Path("id") id: String, @Body maintenanceRequest: MaintenanceRequestsApiModel): Call<Void>

    @DELETE("MaintenanceRequests/{id}")
    fun deleteMaintenanceRequest(@Path("id") id: String): Call<Void>
}