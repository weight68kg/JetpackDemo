package com.weight68kg.jetpackdemo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharacterDao {
    @Query("SELECT * FROM CharacterBean")
    fun getAll(): List<CharacterBean>


    @Query("SELECT * FROM CharacterBean WHERE gender IN (:gender)")
    fun loadAllByGenders(gender: String): List<CharacterBean>


    @Insert
    fun insertAll(vararg users: CharacterBean)

    @Delete
    fun delete(user: CharacterBean)
}