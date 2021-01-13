package com.example.perfumeryscores

import android.app.Application
import com.example.perfumeryscores.db.AppDatabase

class AppApplication : Application() {
    private val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { AppRepository(database.appDao()) }
}