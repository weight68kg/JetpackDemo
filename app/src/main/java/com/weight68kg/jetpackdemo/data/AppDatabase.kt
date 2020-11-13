package com.weight68kg.jetpackdemo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.weight68kg.jetpackdemo.architecture.User

@Database(
    entities = arrayOf(
        CharacterBean::class,
        User::class
    ), version = 1
)
abstract class AppDatabase : RoomDatabase() {
}
