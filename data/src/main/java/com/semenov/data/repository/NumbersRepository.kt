package com.semenov.data.repository

import com.semenov.data.model.EntityNumber
import kotlinx.coroutines.flow.Flow

interface NumbersRepository {
    suspend fun getRandomNumber(): EntityNumber
    suspend fun getNumber(number: Int): EntityNumber
    suspend fun insertNumber(number: EntityNumber)
    suspend fun getAllNumbers(): Flow<List<EntityNumber>>
}