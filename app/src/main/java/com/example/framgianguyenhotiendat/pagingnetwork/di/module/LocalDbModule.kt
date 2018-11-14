package com.example.framgianguyenhotiendat.pagingnetwork.di.module

import android.app.Application
import android.arch.persistence.room.Room
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDbModule {

    @Singleton
    @Provides
    fun provideAppDao(appDatabase: AppDatabase) = appDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(context: Application) = Room.databaseBuilder(
            context, AppDatabase::class.java, AppDatabase.ROOM_DATABSE_NAME).build()
}
