package com.weight68kg.jetpackdemo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//人物
@Entity
class CharacterBean(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String?=null,
    var gender: String?=null,
    var age: Int?=null,
    var weight: Int?=null,
    var height: Int?=null,
    var camp: String?=null,
    var race: String?=null
)




