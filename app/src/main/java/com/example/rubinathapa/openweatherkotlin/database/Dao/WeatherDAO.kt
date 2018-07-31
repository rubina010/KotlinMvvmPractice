package com.example.rubinathapa.openweatherkotlin.database.Dao

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

import com.example.rubinathapa.openweatherkotlin.data.Entity.GetWeatherResponse
import com.example.rubinathapa.openweatherkotlin.data.Entity.Weather
import io.reactivex.Observable

@Dao
interface WeatherDAO {
    @Query("SELECT * FROM weather")
    fun queryWeatherData(): LiveData<GetWeatherResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeatherData(getWeatherResponse: GetWeatherResponse)
}