package com.example.insy7315_poe_p1_v1.Retrofit

import com.example.insy7315_poe_p1_v1.ApiModel.PropertiesApiModel
import retrofit2.Call
import retrofit2.http.*

interface PropertiesApi {

    @GET("Properties")
    fun getAllProperties(): Call<List<PropertiesApiModel>>

    @GET("Properties/{id}")
    fun getPropertyById(@Path("id") id: String): Call<PropertiesApiModel>

    @POST("Properties")
    fun createProperty(@Body property: PropertiesApiModel): Call<Void>

    @PUT("Properties/{id}")
    fun updateProperty(@Path("id") id: String, @Body property: PropertiesApiModel): Call<Void>

    @DELETE("Properties/{id}")
    fun deleteProperty(@Path("id") id: String): Call<Void>
}