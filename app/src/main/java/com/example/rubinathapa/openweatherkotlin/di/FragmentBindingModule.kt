package com.example.rubinathapa.openweatherkotlin.di

import com.example.rubinathapa.openweatherkotlin.di.scope.FragmentScoped
import com.example.rubinathapa.openweatherkotlin.ui.di.WeatherModule
import com.example.rubinathapa.openweatherkotlin.ui.weather.mvvm.WeatherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {
    @FragmentScoped
    @ContributesAndroidInjector(modules = [(WeatherModule::class)])
    abstract fun provideFragment(): WeatherFragment
}