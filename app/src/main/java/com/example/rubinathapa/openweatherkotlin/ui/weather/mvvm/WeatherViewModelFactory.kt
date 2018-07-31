package com.example.rubinathapa.openweatherkotlin.ui.weather.mvvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

class WeatherViewModelFactory @Inject constructor(private val weatherViewModel: WeatherViewModel):
        ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WeatherViewModel::class.java!!))
        {
            return weatherViewModel as T
        }
        throw IllegalArgumentException("unknown class name")
    }

}