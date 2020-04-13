package com.mobile.android.chameapps.towatchlist.ui.mainactivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mobile.android.chameapps.towatchlist.room.entities.Item
import com.mobile.android.chameapps.towatchlist.room.repository.ItemsRepository
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private var repository: ItemsRepository, application: Application) : AndroidViewModel(application) {

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