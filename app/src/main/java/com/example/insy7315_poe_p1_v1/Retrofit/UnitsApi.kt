package com.example.insy7315_poe_p1_v1.Retrofit

import com.example.insy7315_poe_p1_v1.ApiModel.UsersApiModel
import retrofit2.Call
import retrofit2.http.*

interface UnitsApi {

    @GET("Units")
    fun getAllUnits(): Call<List<UsersApiModel>>

    @GET("Units/{id}")
    fun getUnitById(@Path("id") id: String): Call<UsersApiModel>

    @PUT("Units/{id}")
    fun updateUnit(@Path("id") id: String, @Body unit: UsersApiModel): Call<Void>
}