package com.example.perfumeryscores.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scores")
data class Score(
    @PrimaryKey val id: Long?,
    @ColumnInfo(name = "player_id") val playerId: Long,
    @ColumnInfo(name = "history_id") val historyId: Long,
//    @ColumnInfo(name = "total_2") val total2: Int,
//    @ColumnInfo(name = "total_3") val total3: Int,
//    @ColumnInfo(name = "total_4") val total4: Int,
//    @ColumnInfo(name = "total_7") val total7: Int,
//    @ColumnInfo(name = "total_8") val total8: Int,
//    @ColumnInfo(name = "total_14") val total14: Int,
//    @ColumnInfo(name = "total_15") val total15: Int,
    @ColumnInfo(name = "total") val total: Int,
    @ColumnInfo(name = "rank") val rank: Int
)
