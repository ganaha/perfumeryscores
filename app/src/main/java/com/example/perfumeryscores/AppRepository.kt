package com.example.perfumeryscores

import androidx.annotation.WorkerThread
import com.example.perfumeryscores.db.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppRepository(private val dao: AppDao) {
    val players: Flow<List<Player>> = dao.getPlayers()

    suspend fun getPlayerByName(name: String): Player? {
        return dao.getPlayerByName(name)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertPlayer(player: Player): Long {
        return dao.insertPlayer(player)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertHistory(history: History): Long {
        return dao.insertHistory(history)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertScore(score: Score) {
        dao.insertScore(score)
    }

    val histories: Flow<List<HistoryWithScores>> = dao.getHistories().map { histories ->
        histories.map { history ->
            history.scores = history.scores.sortedBy { it.score.rank }
            history
        }
    }

    val playerInfos: Flow<List<PlayerInfo>> = dao.getPlayerInfos()
}