package com.example.testnavigation.data.dao

import androidx.room.*
import com.example.testnavigation.model.Meterage

@Dao
interface MeterageDao {
    @Query("SELECT * FROM meterages")
    fun getAllMeterages(): List<Meterage>

    @Query("SELECT * FROM meterages WHERE id=:id ")
    fun getMeterage(id: String): Meterage

    @Insert
    fun insertMeterage(city: Meterage)

    @Delete
    fun deleteMeterage(city: Meterage)

    @Update
    fun updateMeterage(city: Meterage)
}