package com.example.perfumeryscores.ui.histories

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.perfumeryscores.AppRepository
import com.example.perfumeryscores.db.HistoryWithScores

class HistoriesViewModel(repository: AppRepository) : ViewModel() {
    val histories: LiveData<List<HistoryWithScores>> = repository.histories.asLiveData()
}

class HistoriesViewModelFactory(private val repository: AppRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoriesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HistoriesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}