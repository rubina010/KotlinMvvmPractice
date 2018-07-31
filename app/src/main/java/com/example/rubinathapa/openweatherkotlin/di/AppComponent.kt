package com.example.rubinathapa.openweatherkotlin.di

import com.example.rubinathapa.openweatherkotlin.OpenWeatherKotlinApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, ActivityBindingModule::class, AppModule::class
, ApiModule::class, RxModule::class))
interface AppComponent {
    fun inject(application: OpenWeatherKotlinApplication)
}