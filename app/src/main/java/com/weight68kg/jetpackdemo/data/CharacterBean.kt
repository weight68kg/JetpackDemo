package com.weight68kg.jetpackdemo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//人物
@Entity
class CharacterBean(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String?,
    var gender: String?,
    var age: Int?,
    var weight: Int?,
    var height: Int?,
    var camp: String?,
    var race: String?
)




