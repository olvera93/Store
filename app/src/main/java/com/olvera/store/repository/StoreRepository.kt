package com.olvera.store.repository

import android.content.Context
import android.os.AsyncTask
import com.olvera.store.model.Store
import com.olvera.store.room.StoreDao
import com.olvera.store.room.StoreDatabase

open class StoreRepository(context: Context) {

    private val dataBase: StoreDatabase by lazy {
        StoreDatabase.getInstance(context)
    }

    private val storeDao: StoreDao by lazy {
        dataBase.storeDao()
    }

    fun getAllStores() = storeDao.getAllStores()

    open fun insertStore(store: Store)  {
        InsertStoreAsyncTask(storeDao).execute(store)
    }

    private class InsertStoreAsyncTask(private val storeDao: StoreDao):
            AsyncTask<Store, Void, Void>() {

        @Deprecated("Deprecated in Java")
        override fun doInBackground(vararg param: Store?): Void? {
            param[0]?.let { storeDao.addStore(it) }
            return null
        }
    }

}