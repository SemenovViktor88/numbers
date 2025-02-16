package com.semenov.numbers.di

import android.app.Application
import androidx.room.Room
import com.semenov.data.AppInfoProvider
import com.semenov.data.db.NumberDao
import com.semenov.data.db.NumbersDatabase
import com.semenov.data.network.NumberApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun createRetrofit(infoProvider: AppInfoProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(infoProvider.baseHost)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideNumbersApi(retrofit: Retrofit): NumberApi {
        return retrofit.create(NumberApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): NumbersDatabase {
        return Room.databaseBuilder(app, NumbersDatabase::class.java, "numbers_db",)
            .build()
    }

    @Provides
    fun provideNumberDao(db: NumbersDatabase): NumberDao {
        return db.numbersDao()
    }
}