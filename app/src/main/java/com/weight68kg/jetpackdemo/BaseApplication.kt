package com.weight68kg.jetpackdemo

import android.app.Application
import androidx.room.Room
import androidx.startup.AppInitializer
import com.weight68kg.jetpackdemo.data.AppDatabase
import com.weight68kg.jetpackdemo.startup.ExampleLoggerInitializer
import com.weight68kg.jetpackdemo.startup.WorkManagerInitializer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {

    val appComponent = DaggerApplicationComponent.create()
    override fun onCreate() {
        super.onCreate()

        AppInitializer.getInstance(this)
            .initializeComponent(ExampleLoggerInitializer::class.java)



        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}