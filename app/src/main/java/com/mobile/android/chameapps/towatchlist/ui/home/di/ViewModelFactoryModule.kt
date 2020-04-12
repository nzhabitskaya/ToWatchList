package com.mobile.android.chameapps.towatchlist.ui.home.di;

import androidx.lifecycle.ViewModelProvider;

import com.mobile.android.chameapps.towatchlist.ui.home.ViewModelFactory;

import dagger.Binds;
import dagger.Module;

/**
 * Created by n.zhabitskaya on 9/30/18.
 */

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory:ViewModelFactory): ViewModelProvider.Factory

}
