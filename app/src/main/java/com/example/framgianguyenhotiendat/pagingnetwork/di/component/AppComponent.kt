package com.example.framgianguyenhotiendat.pagingnetwork.di.component

import android.app.Application
import com.example.framgianguyenhotiendat.pagingnetwork.MyApplication
import com.example.framgianguyenhotiendat.pagingnetwork.di.module.ActivityBuilder
import com.example.framgianguyenhotiendat.pagingnetwork.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(mainApplication: MyApplication)
}