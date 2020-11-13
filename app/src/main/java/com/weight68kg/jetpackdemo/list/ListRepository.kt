package com.weight68kg.jetpackdemo.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.weight68kg.jetpackdemo.data.CharacterBean

class ListRepository {
    fun getList(): LiveData<CharacterBean> {
        val data = MutableLiveData<CharacterBean>()

        return data
    }
}