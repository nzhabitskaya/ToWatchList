package com.mobile.android.chameapps.towatchlist.application

import androidx.lifecycle.ViewModelProvider
import com.mobile.android.chameapps.towatchlist.room.di.RoomModule
import com.mobile.android.chameapps.towatchlist.ui.home.HomeFragment
import com.mobile.android.chameapps.towatchlist.ui.home.di.ViewModelFactoryModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by n.zhabitskaya on 9/28/18.
 */

@Singleton
@Component(modules = [ApplicationModule::class, RoomModule::class, ViewModelFactoryModule::class])
interface AppComponent {

    val application: MyApplication?

    val viewModelFactory: ViewModelProvider.Factory

    fun inject(fragment: HomeFragment)
}