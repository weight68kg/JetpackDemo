package com.weight68kg.jetpackdemo

import com.weight68kg.jetpackdemo.list.ListRepository
import com.weight68kg.jetpackdemo.list.ListComponent
import com.weight68kg.jetpackdemo.list.SubcomponentsModule
import com.weight68kg.jetpackdemo.network.NetWorkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetWorkModule::class, SubcomponentsModule::class])
interface ApplicationComponent {
    fun repository(): ListRepository

    fun loginComponent(): ListComponent.Factory
}