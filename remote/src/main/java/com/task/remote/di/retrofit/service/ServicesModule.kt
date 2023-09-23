package com.task.remote.di.retrofit.service

import com.task.remote.di.retrofit.RetrofitModule
import com.task.remote.di.services.Service
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [RetrofitModule::class])

class ServicesModule {

    @Provides
    @Singleton
    fun provideCallReasonsService(
        retrofit: Retrofit
    ): Service {
        return retrofit.create(Service::class.java)
    }
}