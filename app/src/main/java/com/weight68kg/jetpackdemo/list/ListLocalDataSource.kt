package com.weight68kg.jetpackdemo.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.weight68kg.jetpackdemo.data.CharacterBean
import javax.inject.Inject

class ListLocalDataSource @Inject constructor() {
    fun getList(): LiveData<List<CharacterBean>> {
        val data = MutableLiveData<List<CharacterBean>>()

        val list = ArrayList<CharacterBean>()
        list.add(CharacterBean(name = "路飞"))
        list.add(CharacterBean(name = "索隆"))
        list.add(CharacterBean(name = "乌索普"))
        list.add(CharacterBean(name = "山治"))
        list.add(CharacterBean(name = "娜美"))
        list.add(CharacterBean(name = "乔巴"))
        list.add(CharacterBean(name = "弗兰奇"))
        list.add(CharacterBean(name = "罗宾"))
        list.add(CharacterBean(name = "布鲁克"))
        list.add(CharacterBean(name = "甚平"))

        data.value = list

        return data
    }
}