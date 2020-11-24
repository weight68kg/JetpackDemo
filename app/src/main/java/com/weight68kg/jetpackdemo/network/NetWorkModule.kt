package com.weight68kg.jetpackdemo.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetWorkModule {

    @Singleton
    @Provides
    fun provideListRetrofitService(okHttpClient: OkHttpClient): ListRetrofitService {
        return Retrofit.Builder().baseUrl("")
            .client(okHttpClient)
            .build()
            .create(ListRetrofitService::class.java)
    }
}