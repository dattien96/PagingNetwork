package com.example.framgianguyenhotiendat.pagingnetwork.data.source.local.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Note
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.local.db.AppDatabase.Companion.ROOM_VERSION

@Database(entities = [(Note::class)], version = ROOM_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): AppDao

    companion object {
        const val ROOM_VERSION = 2

        const val ROOM_DATABSE_NAME = "noteDatabase.db"
    }
}
