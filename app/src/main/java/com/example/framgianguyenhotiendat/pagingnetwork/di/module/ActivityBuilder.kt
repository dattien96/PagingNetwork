package com.example.framgianguyenhotiendat.pagingnetwork.di.module

import com.example.framgianguyenhotiendat.pagingnetwork.ui.apiload.ApiLoadActivity
import com.example.framgianguyenhotiendat.pagingnetwork.ui.roomload.RoomLoadActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun contributeApiActivity(): ApiLoadActivity

    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
    abstract fun contributeRoomActivity(): RoomLoadActivity
}