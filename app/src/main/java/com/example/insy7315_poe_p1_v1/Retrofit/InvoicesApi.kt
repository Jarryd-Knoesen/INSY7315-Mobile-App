package com.example.insy7315_poe_p1_v1.Retrofit

import com.example.insy7315_poe_p1_v1.ApiModel.InvoicesApiModel
import retrofit2.Call
import retrofit2.http.*

interface InvoicesApi {

    @GET("Invoices")
    fun getAllInvoices(): Call<List<InvoicesApiModel>>

    @GET("Invoices/{id}")
    fun getInvoiceById(@Path("id") id: String): Call<InvoicesApiModel>

    @POST("Invoices")
    fun createInvoice(@Body invoice: InvoicesApiModel): Call<Void>

    @PUT("Invoices/{id}")
    fun updateInvoice(@Path("id") id: String, @Body invoice: InvoicesApiModel): Call<Void>

    @DELETE("Invoices/{id}")
    fun deleteInvoice(@Path("id") id: String): Call<Void>
}