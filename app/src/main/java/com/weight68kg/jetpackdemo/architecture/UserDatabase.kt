package com.weight68kg.jetpackdemo.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.weight68kg.jetpackdemo.architecture.User
import com.weight68kg.jetpackdemo.architecture.UserDao

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
}