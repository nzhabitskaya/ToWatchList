package com.mobile.android.chameapps.towatchlist.ui.mainactivity.di

import androidx.lifecycle.ViewModel
import com.mobile.android.chameapps.towatchlist.factory.ViewModelKey
import com.mobile.android.chameapps.towatchlist.ui.mainactivity.MainActivity
import com.mobile.android.chameapps.towatchlist.ui.mainactivity.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import io.reactivex.Completable
import javax.inject.Qualifier

/**
 * Created by Natallia Zhabitskaya on 04/12/2020.
 */

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @Module
    companion object {
        @JvmStatic
        @Provides
        @OnDestroy
        fun provideOnDestroyCompletable(
            activity: MainActivity
        ): Completable = activity.onDestroyCompletable
    }

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindsMainViewModel(mainViewModel: MainActivityViewModel): ViewModel
}

@Qualifier
@MustBeDocumented
annotation class OnDestroy