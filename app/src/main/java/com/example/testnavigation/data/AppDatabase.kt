package com.example.testnavigation.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testnavigation.model.Meterage
import com.example.testnavigation.data.dao.MeterageDao

@Database(
    entities = [Meterage::class],
    version = 4,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun meterageDao(): MeterageDao
}