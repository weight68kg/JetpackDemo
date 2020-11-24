package com.weight68kg.jetpackdemo

import android.app.Application
import androidx.room.Room
import com.weight68kg.jetpackdemo.data.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {

    val appComponent = DaggerApplicationComponent.create()
    override fun onCreate() {
        super.onCreate()
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}