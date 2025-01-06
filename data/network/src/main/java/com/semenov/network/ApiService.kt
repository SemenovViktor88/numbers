package com.semenov.network

import retrofit2.http.GET

interface ApiService {
    @GET("endpoint")
    suspend fun getInterestingNumbers()
}