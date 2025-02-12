package com.semenov.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.semenov.data.model.EntityNumber

@Dao
interface NumberDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNumber(number: EntityNumber)

    @Query("SELECT * FROM numbers")
    suspend fun getAllNumber(): List<EntityNumber>?
}