package com.example.rubinathapa.openweatherkotlin.di

import com.example.rubinathapa.openweatherkotlin.ui.main.MainActivity
import com.example.rubinathapa.openweatherkotlin.di.scope.ActivityScoped
import com.example.rubinathapa.openweatherkotlin.ui.di.WeatherModule
import com.example.rubinathapa.openweatherkotlin.ui.main.di.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [(MainModule::class)])
    abstract fun bindWeatherActivity(): MainActivity
}
