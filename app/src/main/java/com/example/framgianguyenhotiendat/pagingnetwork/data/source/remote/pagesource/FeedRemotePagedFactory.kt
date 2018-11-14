package com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.pagesource

import android.arch.paging.DataSource
import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Article
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.api.FeedApi
import javax.inject.Inject

/**
 * Factory receive data by using DataSource ( is FeedRemotePagedSource )
 * and PagedList config we imp in ApiLoadViewModel
 */
class FeedRemotePagedFactory @Inject constructor(
        private val feedRemotePagedSource: FeedRemotePagedSource
)
    : DataSource.Factory<Long, Article>() {

    override fun create(): DataSource<Long, Article> = feedRemotePagedSource
}
