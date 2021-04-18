package com.example.mobillabor.model

import com.google.gson.annotations.SerializedName
import java.util.*

class Meterage {
    @SerializedName("license")
    var license: String? = null
    
    @SerializedName("product")
    var product: String? = null
    
    @SerializedName("date")
    var date: Date? = null
    
    @SerializedName("place")
    var place: String? = null

    @SerializedName("values")
    var values: FloatArray? = null
}