package com.weight68kg.jetpackdemo.architecture

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)  val id: Int,
     var name: String,
     var lastName: String
)