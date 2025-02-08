package com.semenov.data.repository

interface NumbersRepository {
    suspend fun getRandomNumber(): String
    suspend fun getNumber(number: String): String
}