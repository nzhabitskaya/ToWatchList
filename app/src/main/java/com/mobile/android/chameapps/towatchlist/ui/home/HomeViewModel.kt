package com.mobile.android.chameapps.towatchlist.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.mobile.android.chameapps.towatchlist.entities.Item
import com.mobile.android.chameapps.towatchlist.repository.ItemsRepository

class HomeViewModel (private var repository: ItemsRepository, application: Application) : AndroidViewModel(application) {

    private var items: LiveData<List<Item>> = repository.getAllItems()

    fun insert(item: Item) {
        repository.insert(item)
    }

    fun deleteAllItems() {
        repository.deleteAllItems()
    }

    fun getItems(): LiveData<List<Item>> {
        return items
    }
}