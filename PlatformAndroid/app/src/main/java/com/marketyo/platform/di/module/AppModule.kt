package com.marketyo.platform.di.module

import android.app.Application
import com.marketyo.platform.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule() {
    @Provides
    fun providesApplication(): Application {
        return App.instance!!
    }
}