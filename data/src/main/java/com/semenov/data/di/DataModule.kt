package com.semenov.data.di

import com.semenov.common.AppInfoProvider
import com.semenov.data.network.NumbersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun createRetrofit(infoProvider: AppInfoProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(infoProvider.baseHost)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideNumbersApi(retrofit: Retrofit): NumbersApi {
        return retrofit.create(NumbersApi::class.java)
    }
}