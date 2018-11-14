package com.example.framgianguyenhotiendat.pagingnetwork.ui.roomload

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Note
import com.example.framgianguyenhotiendat.pagingnetwork.data.repository.AppRepository
import com.example.framgianguyenhotiendat.pagingnetwork.data.repository.DataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RoomLoadViewModel @Inject constructor(
        private val repo: DataSource
) : ViewModel(), LifecycleObserver {

    lateinit var navigator: RoomLoadNavigator

    fun onAddNote(title: String) {
        if (title.isNotEmpty()) {
            repo.insertNote(Note(title = title)).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onSuccess = {
                                it?.let {
                                    navigator.addNoteItem()
                                }
                            },
                            onError = {

                            }
                    )
        }
    }

    fun viewNotes() {
        navigator.goToNoteList()
    }
}