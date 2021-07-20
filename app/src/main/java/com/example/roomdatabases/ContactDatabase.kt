package com.example.roomdatabases

import android.content.Context
import androidx.room.*
import kotlin.contracts.contract

@Database(entities = [Contact::class],version = 1)
@TypeConverters(Convertors::class)
abstract class ContactDatabase:RoomDatabase() {
    abstract fun contactDao():ContactDAO

    companion object{
        @Volatile
        private var INSTANCE: ContactDatabase? = null
        fun getDatabase(context: Context): ContactDatabase{
            if(INSTANCE==null){
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context.applicationContext,ContactDatabase::class.java,"contactDB").build()
                }
            }
            return INSTANCE!!
        }
    }
}
