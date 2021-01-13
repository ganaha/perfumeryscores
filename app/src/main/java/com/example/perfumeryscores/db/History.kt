package com.example.perfumeryscores.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "histories")
data class History(
    @PrimaryKey val id: Long?
)
