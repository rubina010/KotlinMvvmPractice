package com.example.rubinathapa.openweatherkotlin.data

import android.arch.persistence.room.TypeConverter
import com.example.rubinathapa.openweatherkotlin.data.Entity.Weather
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class OpenWeatherTypeConverter {



    @TypeConverter
    fun saveWeatherModel(s:String): List<Weather> {
        return Gson().fromJson(s,object :TypeToken<List<Weather>>(){}.type)
    }
    @TypeConverter
    fun restoreWeatherModel(list:List<Weather>): String{
        return Gson().toJson(list)
    }
}