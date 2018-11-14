package com.example.framgianguyenhotiendat.pagingnetwork.ui.apiload

import android.arch.lifecycle.*
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Article
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.pagesource.FeedRemotePagedFactory
import javax.inject.Inject

class ApiLoadViewModel @Inject constructor(
        feedRemotePagedFactory: FeedRemotePagedFactory
) : ViewModel(), LifecycleObserver {

    val articles: LiveData<PagedList<Article>>

    /**
     * Need to be init in this block. If init articles = null and set after -> can"t get data
     */
    init {
        //the config ( and the factory ), is used for Builder build PagedLiveData
        val pagedListConfig = PagedList.Config.Builder()
                .setEnablePlaceholders(false) //holder when item doesn't fully load
                .setInitialLoadSizeHint(10) //size of item list in the first load
                .setPrefetchDistance(50)
                .setPageSize(10).build() //the number of item to be load

        articles = LivePagedListBuilder(feedRemotePagedFactory, pagedListConfig).build()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startViewModel() {
    }
}
