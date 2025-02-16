package com.semenov.data.repository

import com.semenov.data.model.EntityNumber

interface NumbersRepository {
    suspend fun getRandomNumber(): String
    suspend fun getNumber(number: String): String
    suspend fun insertNumber(number: EntityNumber)
    suspend fun getAllNumbers(): List<EntityNumber>
}