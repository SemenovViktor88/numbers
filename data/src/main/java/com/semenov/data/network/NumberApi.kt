package com.semenov.data.network

import retrofit2.http.GET
import retrofit2.http.Path

interface NumberApi {

    @GET(ApiContract.Numbers.RANDOM)
    suspend fun getRandomNumber(): String

    @GET(ApiContract.Numbers.NUMBER)
    suspend fun getNumber(@Path("number") number: String): String
}