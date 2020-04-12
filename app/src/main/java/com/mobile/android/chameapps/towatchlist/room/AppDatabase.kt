package com.mobile.android.chameapps.towatchlist.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mobile.android.chameapps.towatchlist.entities.Item
import com.mobile.android.chameapps.towatchlist.room.dao.ItemsDao

@Database(
    entities = [Item::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun itemsDao(): ItemsDao?
}