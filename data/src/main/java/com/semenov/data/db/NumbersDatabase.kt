package com.semenov.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.semenov.data.model.EntityNumber

@Database(entities = [EntityNumber::class,], version = 1, exportSchema = false)
abstract class NumbersDatabase: RoomDatabase() {
    abstract fun numbersDao(): NumberDao
}