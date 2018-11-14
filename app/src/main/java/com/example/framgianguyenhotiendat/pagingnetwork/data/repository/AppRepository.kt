package com.example.framgianguyenhotiendat.pagingnetwork.data.repository

import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Note
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.local.LocalDataSource
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.RemoteDatsource
import javax.inject.Inject

class AppRepository @Inject constructor(
        private val localSource: LocalDataSource,
        private val remoteDatsource: RemoteDatsource
) : DataSource {

    override fun getAllNotes() = localSource.getAllNotes()

    override fun getPagedNotes() = localSource.getPagedNotes()

    override fun insertNote(note: Note) = localSource.insertNote(note)

    override fun deleteNote(note: Note) {
        localSource.deleteNote(note)
    }

    override fun saveNoteDrafts(title: String) {
        localSource.saveNoteDrafts(title)
    }
}
