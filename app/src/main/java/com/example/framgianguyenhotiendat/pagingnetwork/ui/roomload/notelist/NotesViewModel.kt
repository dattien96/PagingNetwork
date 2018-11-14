package com.example.framgianguyenhotiendat.pagingnetwork.ui.roomload.notelist

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.arch.paging.DataSource
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Note
import com.example.framgianguyenhotiendat.pagingnetwork.data.repository.AppRepository
import javax.inject.Inject

class NotesViewModel @Inject constructor(
        private val repo: AppRepository
) : ViewModel(), LifecycleObserver {

    lateinit var notes: LiveData<PagedList<Note>>
    lateinit var factory: DataSource.Factory<Int, Note>
    lateinit var pageConfig: PagedList.Config

    init {
        getNotesByPaging()
    }

    private fun getNotesByPaging() {
        //the config ( and the factory ), is used for Builder build PagedLiveData
        pageConfig = PagedList.Config.Builder()
                .setEnablePlaceholders(false) //holder when item doesn't fully load
                .setInitialLoadSizeHint(10) //size of item list in the first load
                .setPrefetchDistance(50)
                .setPageSize(10).build() //the number of item to be load

        factory = repo.getPagedNotes()
        notes = LivePagedListBuilder(factory, pageConfig).build()
    }
}