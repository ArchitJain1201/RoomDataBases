package com.example.roomdatabases

import androidx.room.TypeConverter
import java.util.*

class Convertors {
    @TypeConverter
    fun fromDataToLong(value: Date): Long{
        return value.time
    }
    @TypeConverter
    fun  fromLongToDate(value: Long): Date{
        return Date(value)
    }
}