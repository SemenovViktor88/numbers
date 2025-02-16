package com.semenov.domain

import com.semenov.data.db.NumberDao
import com.semenov.data.model.EntityNumber
import com.semenov.data.network.NumberApi
import com.semenov.data.repository.NumbersRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NumbersRepositoryImpl @Inject constructor(
    private val numbersApi: NumberApi,
    private val numbersDao: NumberDao,
) : NumbersRepository {

    override suspend fun getRandomNumber() = numbersApi.getRandomNumber()

    override suspend fun getNumber(number: String) = numbersApi.getNumber(number)

    override suspend fun getAllNumbers() = numbersDao.getAllNumbers()

    override suspend fun insertNumber(number: EntityNumber) {
        numbersDao.insertNumber(number)
    }
}