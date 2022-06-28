package com.olvera.store.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.olvera.store.model.Store

@Dao
interface StoreDao {

    @Query(value = "SELECT * FROM Store")
    fun getAllStores(): LiveData<List<Store>>

    @Insert
    fun addStore(storeEntity: Store)

    @Delete
    fun deleteStore(vararg storeEntity: Store)

}