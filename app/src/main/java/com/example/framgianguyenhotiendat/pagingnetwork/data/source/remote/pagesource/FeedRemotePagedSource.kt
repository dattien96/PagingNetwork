package com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.pagesource

import android.arch.paging.PageKeyedDataSource
import android.util.Log
import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Article
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.api.FeedApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FeedRemotePagedSource constructor(
        private val feedApi: FeedApi
) : PageKeyedDataSource<Long, Article>() {

    /**
     * Method init load for the first time app run
     */
    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<Long, Article>) {
        Log.d("xxxx", "init size  = " + params.requestedLoadSize)
        feedApi.fetchFeed("movie", "079dac74a5f94ebdb990ecf61c8854b7", 1, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onError = {

                        },
                        onSuccess = {
                            it.articles?.let { articles ->
                                callback.onResult(articles, null, 2L)
                            }
                        }
                )
    }

    /**
     * Execute in bg thread
     * Fetch next page of data
     * "params.key" will have the updated value
     */
    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, Article>) {
        feedApi.fetchFeed("movie", "079dac74a5f94ebdb990ecf61c8854b7", params.key, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onError = {

                        },
                        onSuccess = {
                            it.articles?.let { articles ->
                                callback.onResult(articles, params.key + 1)
                            }
                        }
                )
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, Article>) {

    }
}
