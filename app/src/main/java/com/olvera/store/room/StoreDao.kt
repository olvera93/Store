package com.olvera.store.room

import androidx.room.*
import com.olvera.store.model.Store

@Dao
interface StoreDao {

    @Query(value = "SELECT * FROM Store")
    fun getAllStores(): MutableList<Store>

    @Insert
    fun addStore(storeEntity: Store)

    @Update
    fun updateStore(storeEntity: Store)

    @Delete
    fun deleteStore(storeEntity: Store)

}