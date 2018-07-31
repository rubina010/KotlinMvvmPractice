package com.example.rubinathapa.openweatherkotlin.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import com.example.rubinathapa.openweatherkotlin.data.Entity.GetWeatherResponse
import com.example.rubinathapa.openweatherkotlin.data.Entity.Weather
import com.example.rubinathapa.openweatherkotlin.data.OpenWeatherTypeConverter
import com.example.rubinathapa.openweatherkotlin.database.Dao.WeatherDAO

@Database(entities = arrayOf(GetWeatherResponse::class), version = 1,exportSchema = false)
@TypeConverters(OpenWeatherTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDAO

}