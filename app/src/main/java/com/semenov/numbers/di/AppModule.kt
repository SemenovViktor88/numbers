package com.semenov.numbers.di

import android.app.Application
import com.semenov.data.AppInfoProvider
import com.semenov.numbers.util.AppInfoProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideInfoProvider(
        context: Application,
    ): AppInfoProvider {
        return AppInfoProviderImpl(context)
    }
}