package com.mobile.android.chameapps.towatchlist.room.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "items", indices = [Index(value = ["title"], unique = true)])
data class Item(

    var title: String,

    var timestamp: String,

    var rating: Double

) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
