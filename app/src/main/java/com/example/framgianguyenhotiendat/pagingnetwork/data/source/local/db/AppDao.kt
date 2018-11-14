package com.example.framgianguyenhotiendat.pagingnetwork.data.source.local.db

import android.arch.paging.DataSource
import android.arch.persistence.room.*
import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Note
import io.reactivex.Single

@Dao
interface AppDao {

    @Query("SELECT * FROM note")
    fun getAllNotes(): Single<List<Note>>

    @Query("SELECT * FROM note")
    fun getPagedNotes(): DataSource.Factory<Int, Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note): Long

    @Delete
    fun deleteNote(note: Note)
}
