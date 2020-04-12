package com.mobile.android.chameapps.towatchlist.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobile.android.chameapps.towatchlist.application.MyApplication
import com.mobile.android.chameapps.towatchlist.repository.ItemsRepository
import com.mobile.android.chameapps.towatchlist.ui.home.HomeViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(private val repository: ItemsRepository, private val application: MyApplication): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java!!)) {
            HomeViewModel(this.repository, application) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}