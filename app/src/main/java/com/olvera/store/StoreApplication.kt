package com.olvera.store

import android.app.Application
import com.olvera.store.repository.StoreRepository
import com.olvera.store.room.StoreDatabase

class StoreApplication: Application() {

    val storeRepository: StoreRepository
        get() = StoreRepository(
            StoreDatabase.getInstance(this)!!.storeDao()
        )
}