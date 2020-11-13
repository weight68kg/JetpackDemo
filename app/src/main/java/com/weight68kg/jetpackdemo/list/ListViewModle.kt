package com.weight68kg.jetpackdemo.list

import android.app.Application
import androidx.lifecycle.*
import com.weight68kg.jetpackdemo.architecture.User
import com.weight68kg.jetpackdemo.architecture.UserRepository
import com.weight68kg.jetpackdemo.data.CharacterBean

class ListViewModle(
    application: Application,
    savedStateHandle: SavedStateHandle,
    repository: ListRepository
) : AndroidViewModel(application) {


    val user: LiveData<List<CharacterBean>> = repository.getList()
}