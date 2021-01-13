package com.example.perfumeryscores.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Query("SELECT * FROM players ORDER BY name ASC")
    fun getPlayers(): Flow<List<Player>>

    @Query("SELECT * FROM players WHERE name = :name LIMIT 1")
    suspend fun getPlayerByName(name: String): Player?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPlayer(player: Player): Long

    @Insert
    suspend fun insertHistory(history: History): Long

    @Insert
    suspend fun insertScore(score: Score)

    @Transaction
    @Query("SELECT * FROM histories ORDER BY id DESC")
    fun getHistories(): Flow<List<HistoryWithScores>>
}