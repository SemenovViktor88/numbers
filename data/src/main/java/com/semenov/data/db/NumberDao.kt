package com.semenov.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.semenov.data.model.EntityNumber
import kotlinx.coroutines.flow.Flow

@Dao
interface NumberDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNumber(number: EntityNumber)

    @Query("SELECT * FROM numbers")
    fun getAllNumbers(): Flow<List<EntityNumber>>

    @Query("SELECT * FROM numbers WHERE number = :number LIMIT 1")
    suspend fun getNumber(number: Int): EntityNumber?
}