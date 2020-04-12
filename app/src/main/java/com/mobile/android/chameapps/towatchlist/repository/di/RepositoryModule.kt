package com.mobile.android.chameapps.towatchlist.factory.di

import com.mobile.android.chameapps.towatchlist.repository.ItemsRepository
import com.mobile.android.chameapps.towatchlist.room.dao.ItemsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Natallia Zhabitskaya on 04/12/2020.
 */

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesItemsRepository(itemsDao: ItemsDao?): ItemsRepository {
        return ItemsRepository(itemsDao!!)
    }
}