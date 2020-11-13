package com.weight68kg.jetpackdemo.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(CharacterBean::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
}