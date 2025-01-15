package com.semenov.data.repository

interface NumbersRepository {
    suspend fun getRandomNumber()
    suspend fun getNumber(number: String)
}