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

    @Query(
        """
        SELECT ps1.name as name, ps1.game as game, COALESCE(ps2.win, 0) AS win, ps3.max as best
                FROM (
                    SELECT p1.name AS name, COUNT(s1.id) AS game FROM players AS p1, scores AS s1
                    WHERE p1.id = s1.player_id
                    GROUP BY p1.name
                ) AS ps1, (
                    SELECT p3.name AS name, MAX(s3.total) AS max FROM players AS p3, scores AS s3
                    WHERE p3.id = s3.player_id
                    GROUP BY p3.name
                ) AS ps3
            LEFT JOIN (
                SELECT p2.name AS name, COUNT(s2.id) AS win FROM players AS p2, scores AS s2
                WHERE p2.id = s2.player_id AND s2.rank = 1
                GROUP BY p2.name
            ) AS ps2
            ON ps1.name = ps2.name
            WHERE ps1.name = ps3.name
            ORDER BY win DESC
    """
    )
    fun getPlayerInfos(): Flow<List<PlayerInfo>>
}