package com.example.rubinathapa.openweatherkotlin.data

import com.example.rubinathapa.openweatherkotlin.data.Entity.GetWeatherResponse
import com.example.rubinathapa.openweatherkotlin.data.Entity.Weather
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("/data/2.5/weather?q=London&appid=d36f8e0ae9058309e528994dae50ce75")
    fun getResponseFromServer(): Observable<GetWeatherResponse>


}