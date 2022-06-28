package com.olvera.store.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.olvera.store.model.Store

@Database(entities = [Store::class], version = 1)
abstract class StoreDatabase: RoomDatabase() {


    abstract fun storeDao(): StoreDao

    companion object { // Esta clase es un singleton por lo que solo se crea una vez y se utiliza para acceder a la base de datos de manera global

        private var instance: StoreDatabase? = null

        fun getInstance(context: Context): StoreDatabase? {
            if (instance == null) {
                synchronized(StoreDatabase::class) {
                    Room.databaseBuilder(context.applicationContext,
                    StoreDatabase::class.java,
                    "store_db")
                        .fallbackToDestructiveMigration()
                        .build()
                        .also { instance = it }
                }
            }
            return  instance
        }
    }
}