package com.example.roomdatabases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var database2 = ContactDatabase.getDatabase(this)
        database = ContactDatabase.getDatabase(this)
        /*database=Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"contactDB").build()*/
        GlobalScope.launch{
            database.contactDao().insertContact(Contact(0, "John", "99999", Date()))
        }
    }

    fun getData(view: View) {
        database.contactDao().getContact().observe(this, Observer {
            Log.d("Archit",it.toString())
        })
    }
}