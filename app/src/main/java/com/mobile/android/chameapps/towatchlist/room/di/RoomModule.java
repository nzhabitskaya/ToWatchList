package com.mobile.android.chameapps.towatchlist.room.di;

import android.app.Application;

import androidx.room.Room;

import com.mobile.android.chameapps.towatchlist.repository.ItemsRepository;
import com.mobile.android.chameapps.towatchlist.room.AppDatabase;
import com.mobile.android.chameapps.towatchlist.room.dao.ItemsDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by n.zhabitskaya on 9/30/18.
 */

@Module
public class RoomModule {

    private AppDatabase database;

    public RoomModule(Application mApplication) {
        database = Room.databaseBuilder(mApplication, AppDatabase.class, "to_watch_list_db").build();
    }

    @Singleton
    @Provides
    AppDatabase providesRoomDatabase() {
        return database;
    }

    @Singleton
    @Provides
    ItemsDao providesItemsDao(AppDatabase database) {
        return database.itemsDao();
    }

    @Singleton
    @Provides
    ItemsRepository providesItemsRepository(ItemsDao itemsDao) {
        return new ItemsRepository(itemsDao);
    }
}
