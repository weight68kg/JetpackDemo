package com.weight68kg.jetpackdemo.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.weight68kg.jetpackdemo.data.CharacterBean
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListRepository @Inject constructor(
    private val localDataSource: ListLocalDataSource,
    private val remoteDataSource: ListRemoteDataSource
) {
    fun getList(): LiveData<List<CharacterBean>> {
        return localDataSource.getList()
    }
}