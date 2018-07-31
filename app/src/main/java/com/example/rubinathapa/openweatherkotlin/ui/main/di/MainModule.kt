package com.example.rubinathapa.openweatherkotlin.ui.main.di

import com.example.rubinathapa.openweatherkotlin.di.scope.ActivityScoped
import com.example.rubinathapa.openweatherkotlin.ui.weather.mvvm.WeatherFragment
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @ActivityScoped
    @Provides
    fun provideWeatherFragment(): WeatherFragment = WeatherFragment()
}