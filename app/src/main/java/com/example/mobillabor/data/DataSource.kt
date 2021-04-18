package com.example.mobillabor.data

import com.example.mobillabor.data.dao.MeterageDao
import com.example.mobillabor.model.Meterage
import javax.inject.Inject

class DataSource @Inject constructor(
    private val meterageDao: MeterageDao
) {

    fun getAllMeterages(): List<Meterage> {
        return meterageDao.getAllMeterages()
    }

    fun getMeterage(id: String): Meterage {
        return meterageDao.getMeterage(id)
    }

    fun saveMeterage(meterage: Meterage): Meterage {
        meterageDao.insertMeterage(meterage)
        return meterage;
    }

    fun updateMeterage(meterage: Meterage): Meterage {
        meterageDao.updateMeterage(meterage)
        return meterage;
    }

    fun deleteMeterage(meterage: Meterage) {
        meterageDao.deleteMeterage(meterage)
    }
}