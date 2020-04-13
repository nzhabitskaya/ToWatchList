package com.mobile.android.chameapps.towatchlist.application

import com.mobile.android.chameapps.towatchlist.factory.di.ViewModelFactoryModule
import com.mobile.android.chameapps.towatchlist.room.di.RoomModule
import com.mobile.android.chameapps.towatchlist.ui.mainactivity.di.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by n.zhabitskaya on 9/28/18.
 */

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, RoomModule::class, MainActivityModule::class, ViewModelFactoryModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: MyApplication)
}