package com.example.rubinathapa.openweatherkotlin.di

import com.example.rubinathapa.openweatherkotlin.MainActivity
import com.example.rubinathapa.openweatherkotlin.di.scope.ActivityScoped
import com.example.rubinathapa.openweatherkotlin.ui.di.WeatherModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [(WeatherModule::class)])
    abstract fun bindWeatherActivity(): MainActivity
}
