package com.example.testnavigation.data

import androidx.room.TypeConverter
import java.util.*
import kotlin.collections.ArrayList

class Converters {

    @TypeConverter
    fun fromArrayListOfFloats(list: FloatArray?): String {
        return list?.joinToString(separator = ";") { it.toString() } ?: ""
    }

    @TypeConverter
    fun toArrayListOfFloats(string: String?): FloatArray {
        return string?.split(";")?.mapNotNull( { it.toFloatOrNull() })?.toFloatArray() ?: FloatArray(0)
    }

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}