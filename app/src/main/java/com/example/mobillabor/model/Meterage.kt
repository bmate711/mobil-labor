package com.example.mobillabor.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "meterages")
class Meterage {
    @PrimaryKey()
    @NonNull
    var id: String? = null

    @SerializedName("license")
    @ColumnInfo(name = "license")
    var license: String? = null
    
    @SerializedName("product")
    @ColumnInfo(name = "product")
    var product: String? = null
    
    @SerializedName("date")
    @ColumnInfo(name = "date")
    var date: Date? = null
    
    @SerializedName("place")
    @ColumnInfo(name = "place")
    var place: String? = null

    @SerializedName("values")
    @ColumnInfo(name = "values")
    var values: FloatArray? = null
}