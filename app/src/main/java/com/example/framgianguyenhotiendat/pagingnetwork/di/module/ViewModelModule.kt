package com.example.framgianguyenhotiendat.pagingnetwork.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.framgianguyenhotiendat.pagingnetwork.ui.ViewModelProviderFactory
import com.example.framgianguyenhotiendat.pagingnetwork.ui.apiload.ApiLoadViewModel
import com.example.framgianguyenhotiendat.pagingnetwork.ui.roomload.RoomLoadViewModel
import com.example.framgianguyenhotiendat.pagingnetwork.ui.roomload.notelist.NotesViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(providerFactory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ApiLoadViewModel::class)
    abstract fun bindApiLoadViewModel(apiLoadViewModel: ApiLoadViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RoomLoadViewModel::class)
    abstract fun bindRoomLoadViewModel(roomLoadViewModel: RoomLoadViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NotesViewModel::class)
    abstract fun bindNotesViewModel(notesViewModel: NotesViewModel): ViewModel
}
