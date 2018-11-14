package com.example.framgianguyenhotiendat.pagingnetwork.di.module

import com.example.framgianguyenhotiendat.pagingnetwork.data.repository.AppRepository
import com.example.framgianguyenhotiendat.pagingnetwork.data.repository.DataSource
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.local.LocalDataSource
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.local.LocalDataSourceImpl
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.RemoteDataSourceImpl
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.RemoteDatsource
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideAppRepository(appRepo: AppRepository): DataSource

    @Binds
    abstract fun provideLocalSource(localSourceImp: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun provideRemoteSource(remoteSourceImp: RemoteDataSourceImpl): RemoteDatsource
}
