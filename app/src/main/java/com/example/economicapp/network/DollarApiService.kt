package com.example.economicapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://economic-dollar-app.herokuapp.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DollarApiService {
    @GET("api/dollar")
    suspend fun getDollar() : Dollar

    @GET("api/dollar/historical")
    suspend fun getHistorical() : List<DollarHistorical>

}

object DollarApi {
    val retrofitService : DollarApiService by lazy {
        retrofit.create(DollarApiService::class.java)
    }
}