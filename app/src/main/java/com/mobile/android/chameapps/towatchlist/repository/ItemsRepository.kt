package com.mobile.android.chameapps.towatchlist.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.mobile.android.chameapps.towatchlist.entities.Item
import com.mobile.android.chameapps.towatchlist.room.dao.ItemsDao

class ItemsRepository(private val itemsDao: ItemsDao) {

    private var items: LiveData<List<Item>>

    init {
        items = itemsDao.findAll()
    }

    fun insert(note: Item) {
        val insertNoteAsyncTask = InsertNoteAsyncTask(itemsDao).execute(note)
    }

    fun deleteAllItems() {
        val deleteAllNotesAsyncTask = DeleteAllNotesAsyncTask(
            itemsDao
        ).execute()
    }

    fun getAllItems(): LiveData<List<Item>> {
        return items
    }

    private class InsertNoteAsyncTask(val noteDao: ItemsDao) : AsyncTask<Item, Unit, Unit>() {

        override fun doInBackground(vararg p0: Item?) {
            noteDao.insert(p0[0]!!)
        }
    }


    private class DeleteAllNotesAsyncTask(val itemsDao: ItemsDao) : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg p0: Unit?) {
            //itemsDao.deleteAllNotes()
        }
    }

}