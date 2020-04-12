package com.mobile.android.chameapps.towatchlist.application

import android.app.Application
import android.content.Context
import com.mobile.android.chameapps.towatchlist.room.di.RoomModule

class MyApplication : Application() {
    private var component: AppComponent? = null
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun getAppComponent(context: Context): AppComponent? {
        val app = context.applicationContext as MyApplication
        if (app.component == null) {
            app.component = DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(instance!!))
                .roomModule(RoomModule(instance!!))
                .build()
        }
        return app.component
    }

    companion object {
        var instance: MyApplication? = null
            private set
    }
}