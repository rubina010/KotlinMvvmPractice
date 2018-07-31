package com.example.rubinathapa.openweatherkotlin.ui.weather.mvvm

import android.arch.lifecycle.LiveData
import com.example.rubinathapa.openweatherkotlin.data.ApiService
import com.example.rubinathapa.openweatherkotlin.data.Entity.GetWeatherResponse
import com.example.rubinathapa.openweatherkotlin.database.Dao.WeatherDAO
import io.reactivex.Observable
import javax.inject.Inject

class WeatherRepository @Inject constructor(val apiService: ApiService, val weatherDAO: WeatherDAO) {
    fun getWeatherDataFromDb(): LiveData<GetWeatherResponse> {
        return weatherDAO.queryWeatherData()
    }

    fun saveInDatabase(getWeatherResponse: GetWeatherResponse) {
        weatherDAO.insertWeatherData(getWeatherResponse)
    }

    fun getDataFromServer(): Observable<GetWeatherResponse> {
        return apiService.getResponseFromServer()
    }


}
