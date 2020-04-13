package com.mobile.android.chameapps.towatchlist.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mobile.android.chameapps.towatchlist.room.entities.Item

@Dao
interface ItemsDao {
    @Query("SELECT * FROM items ORDER BY timestamp DESC")
    fun findAll(): LiveData<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Item): Long

    @Update
    fun update(item: Item): Int

    @Delete
    fun delete(item: Item)
}