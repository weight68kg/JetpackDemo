package com.weight68kg.jetpackdemo.list

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module(subcomponents = arrayOf(ListComponent::class))
class SubcomponentsModule {}