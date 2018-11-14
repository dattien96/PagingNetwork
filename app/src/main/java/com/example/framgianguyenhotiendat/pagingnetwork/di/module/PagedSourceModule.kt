package com.example.framgianguyenhotiendat.pagingnetwork.di.module

import com.example.framgianguyenhotiendat.pagingnetwork.data.source.local.db.AppDao
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.api.FeedApi
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.pagesource.FeedRemotePagedSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PagedSourceModule {

    @Singleton
    @Provides
    fun provideFeedRemoteDataSource(api: FeedApi) = FeedRemotePagedSource(api)
}
