package org.eu.noobshubham.kontests.network

import org.eu.noobshubham.kontests.model.Kontests
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BASE_URL = "https://kontests.net/"
    }

    @GET("api/v1/all")
    suspend fun getAllKontests(): List<Kontests>
}