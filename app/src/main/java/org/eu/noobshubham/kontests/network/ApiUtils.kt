package org.eu.noobshubham.kontests.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtils {
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val konestsService: ApiService by lazy { getInstance().create(ApiService::class.java) }
}