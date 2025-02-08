package com.semenov.domain

import com.semenov.data.network.NumbersApi
import com.semenov.data.repository.NumbersRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NumbersRepositoryImpl @Inject constructor(
    private val numbersApi: NumbersApi
) : NumbersRepository {

    override suspend fun getRandomNumber() = numbersApi.getRandomNumber()

    override suspend fun getNumber(number: String) = numbersApi.getNumber(number)
}