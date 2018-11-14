package com.example.framgianguyenhotiendat.pagingnetwork.data.source.local

import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Note
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.local.db.AppDao
import io.reactivex.Single
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
        private val appDao: AppDao
) : LocalDataSource {

    override fun getAllNotes() = appDao.getAllNotes()

    override fun getPagedNotes() = appDao.getPagedNotes()

    override fun insertNote(note: Note) = Single.create<Long> { it.onSuccess(appDao.insertNote(note)) }

    override fun deleteNote(note: Note) {
        appDao.deleteNote(note)
    }

    override fun saveNoteDrafts(title: String) {

    }
}
