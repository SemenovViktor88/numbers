package com.semenov.domain.di

import com.semenov.data.network.NumbersApi
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
    fun provideNumbersRepository(numbersApi: NumbersApi): NumbersRepository {
        return NumbersRepositoryImpl(numbersApi)
    }
}