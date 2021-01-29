package com.example.perfumeryscores.ui.players

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.perfumeryscores.AppRepository
import com.example.perfumeryscores.db.PlayerInfo

class PlayersViewModel(repository: AppRepository) : ViewModel() {
    val players: LiveData<List<PlayerInfo>> = repository.playerInfos.asLiveData()
}

class PlayersViewModelFactory(private val repository: AppRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayersViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PlayersViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}