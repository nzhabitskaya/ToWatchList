package com.mobile.android.chameapps.towatchlist.factory.di

import androidx.lifecycle.ViewModelProvider
import com.mobile.android.chameapps.towatchlist.application.MyApplication
import com.mobile.android.chameapps.towatchlist.factory.ViewModelFactory
import com.mobile.android.chameapps.towatchlist.repository.ItemsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Natallia Zhabitskaya on 04/12/2020.
 */

@Module
class ViewModelFactoryModule {

    @Singleton
    @Provides
    fun providesViewModelFactory(repository: ItemsRepository, application: MyApplication): ViewModelProvider.Factory {
        return ViewModelFactory(repository, application)
    }
}