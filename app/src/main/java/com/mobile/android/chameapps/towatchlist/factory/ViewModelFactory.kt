package com.mobile.android.chameapps.towatchlist.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobile.android.chameapps.towatchlist.application.MyApplication
import com.mobile.android.chameapps.towatchlist.room.repository.ItemsRepository
import com.mobile.android.chameapps.towatchlist.ui.mainactivity.MainActivityViewModel
import dagger.MapKey
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
class ViewModelFactory @Inject constructor(
    private val repository: ItemsRepository,
    private val application: MyApplication
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            MainActivityViewModel(this.repository, application) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)