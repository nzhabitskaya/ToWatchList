package com.mobile.android.chameapps.towatchlist.application

import androidx.lifecycle.ViewModelProvider
import com.mobile.android.chameapps.towatchlist.factory.di.RepositoryModule
import com.mobile.android.chameapps.towatchlist.factory.di.ViewModelFactoryModule
import com.mobile.android.chameapps.towatchlist.room.di.RoomModule
import com.mobile.android.chameapps.towatchlist.ui.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by n.zhabitskaya on 9/28/18.
 */

@Singleton
@Component(modules = [ApplicationModule::class, RoomModule::class, RepositoryModule::class, ViewModelFactoryModule::class])
interface AppComponent {

    val application: MyApplication?

    val viewModelFactory: ViewModelProvider.Factory

    fun inject(fragment: HomeFragment)
}