package com.olvera.store.repository

import androidx.lifecycle.LiveData
import com.olvera.store.model.Store
import com.olvera.store.room.StoreDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class StoreRepository(private val storeDao: StoreDao,
private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) {

    fun getStores(): LiveData<List<Store>> {
        return storeDao.getAllStores()
    }

    suspend fun addStore(store: Store) {
        coroutineScope {
            launch { storeDao.addStore(store) }
        }
    }

    suspend fun deteleStore(store: Store) {
        coroutineScope {
            launch { storeDao.deleteStore(store) }
        }
    }
}