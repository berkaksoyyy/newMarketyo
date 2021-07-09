package com.marketyo.platform.di

import android.content.Context
import androidx.room.Room
import com.marketyo.platform.data.local.AppDatabase
import com.marketyo.platform.data.local.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "app.db"
        ).build()
    }

    @Provides
    fun provideMarketyoDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }
}