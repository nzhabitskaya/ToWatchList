package com.mobile.android.chameapps.towatchlist.room.di

import androidx.room.Room
import com.mobile.android.chameapps.towatchlist.application.MyApplication
import com.mobile.android.chameapps.towatchlist.room.AppRoomDataBase
import com.mobile.android.chameapps.towatchlist.room.dao.ItemsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by n.zhabitskaya on 9/30/18.
 */
@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideAppDatabase(application: MyApplication): AppRoomDataBase =
        Room.databaseBuilder(
            application,
            AppRoomDataBase::class.java, "to_watch_list_db"
        )
            .build()


    @Singleton
    @Provides
    fun providesItemsDao(database: AppRoomDataBase): ItemsDao? {
        return database.itemsDao()
    }
}