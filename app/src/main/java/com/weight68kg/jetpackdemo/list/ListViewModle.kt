package com.weight68kg.jetpackdemo.list

import android.app.Application
import androidx.lifecycle.*
import com.weight68kg.jetpackdemo.DaggerApplicationComponent
import com.weight68kg.jetpackdemo.architecture.User
import com.weight68kg.jetpackdemo.architecture.UserRepository
import com.weight68kg.jetpackdemo.data.CharacterBean
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class ListViewModle @Inject constructor(
//    application: Application,
//    savedStateHandle: SavedStateHandle,
    repository: ListRepository
) : ViewModel() {


    val user: LiveData<List<CharacterBean>> = repository.getList()


    class Factory(
//        val application: Application,
//        val savedStateHandle: SavedStateHandle
    ) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            val create = DaggerApplicationComponent.create()
            val repository = create.repository()
            return ListViewModle(repository) as T
        }
    }
}

