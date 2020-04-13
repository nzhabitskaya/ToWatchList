package com.mobile.android.chameapps.towatchlist.factory.di

import androidx.lifecycle.ViewModelProvider
import com.mobile.android.chameapps.towatchlist.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created by Natallia Zhabitskaya on 04/12/2020.
 */

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}