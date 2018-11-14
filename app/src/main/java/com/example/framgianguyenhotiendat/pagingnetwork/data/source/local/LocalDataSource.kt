package com.example.framgianguyenhotiendat.pagingnetwork.data.source.local

import android.arch.paging.DataSource
import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Note
import io.reactivex.Single

interface LocalDataSource {
    fun getAllNotes(): Single<List<Note>>

    fun getPagedNotes(): DataSource.Factory<Int, Note>

    fun insertNote(note: Note): Single<Long>

    fun deleteNote(note: Note)

    fun saveNoteDrafts(title: String)
}