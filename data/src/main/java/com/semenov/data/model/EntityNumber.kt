package com.semenov.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "numbers")
data class EntityNumber(
    @PrimaryKey
    @ColumnInfo(name = "number") val number: Int,
    @ColumnInfo(name = "description") val description: String,
)