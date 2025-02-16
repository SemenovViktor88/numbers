package com.semenov.numbers.di

import com.semenov.data.db.NumberDao
import com.semenov.data.network.NumberApi
import com.semenov.data.repository.NumbersRepository
import com.semenov.domain.NumbersRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideNumbersRepository(numbersApi: NumberApi, numberDao: NumberDao): NumbersRepository {
        return NumbersRepositoryImpl(numbersApi, numberDao)
    }
}