package com.semenov.domain

import com.semenov.data.db.NumberDao
import com.semenov.data.model.EntityNumber
import com.semenov.data.network.NumberApi
import com.semenov.data.repository.NumbersRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NumbersRepositoryImpl @Inject constructor(
    private val api: NumberApi,
    private val dao: NumberDao,
) : NumbersRepository {

    override suspend fun getRandomNumber(): EntityNumber {
        val fact = api.getRandomNumber()
        val number = Regex("\\d+").find(fact)?.value?.toInt()

        if (number != null) {
            val cachedFact = dao.getNumber(number)
            if (cachedFact == null) {
                dao.insertNumber(EntityNumber(number, fact))
            }
        }
        val entity = EntityNumber(number = number ?: 0, description = fact)
        return entity
    }

    override suspend fun getNumber(number: Int): EntityNumber {
        val cachedFact = dao.getNumber(number)
        if (cachedFact != null) {
            return cachedFact
        }

        val fact = api.getNumber(number.toString())
        val entity = EntityNumber(number = number, description = fact)
        dao.insertNumber(entity)
        return entity
    }

    override suspend fun getAllNumbers() = dao.getAllNumbers()

    override suspend fun insertNumber(number: EntityNumber) {
        dao.insertNumber(number)
    }
}