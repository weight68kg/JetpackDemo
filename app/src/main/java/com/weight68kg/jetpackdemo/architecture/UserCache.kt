package com.weight68kg.jetpackdemo.architecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class UserCache {
    var user = MutableLiveData<User>()
    fun get(userId: String): LiveData<User> {
        return user
    }

    fun put(userId: String, user: MutableLiveData<User>) {
        this.user = user
    }
}