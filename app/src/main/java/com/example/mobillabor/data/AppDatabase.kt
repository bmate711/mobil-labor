package com.example.mobillabor.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mobillabor.model.Meterage
import com.example.mobillabor.data.dao.MeterageDao

@Database(
    entities = [Meterage::class],
    version = 4,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun meterageDao(): MeterageDao
}