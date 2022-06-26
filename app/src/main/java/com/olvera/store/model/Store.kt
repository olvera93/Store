package com.olvera.store.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Store")
data class Store(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String,
    var phone: String = "",
    var webSite: String = "",
    var isFavorite: Boolean = false)
