package com.weight68kg.jetpackdemo.list

import dagger.Subcomponent
import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
@Subcomponent
interface ListComponent {

    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): ListComponent
    }

    fun inject(listFragment: ListFragment)
}