package com.weight68kg.jetpackdemo.architecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class UserProfileViewModel constructor(
    savedStateHandle: SavedStateHandle,
    userRepository: UserRepository
) : ViewModel() {

    val userId: String =
        savedStateHandle["uid"] ?: throw IllegalArgumentException("missing user id")
    val user: LiveData<User> = userRepository.getUser(userId)

}