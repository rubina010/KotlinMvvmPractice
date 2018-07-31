package com.example.rubinathapa.openweatherkotlin.di

import com.example.rubinathapa.openweatherkotlin.OpenWeatherKotlinApplication
import com.example.rubinathapa.openweatherkotlin.ui.main.di.MainModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, ActivityBindingModule::class, AppModule::class
, ApiModule::class, RxModule::class, MainModule::class, FragmentBindingModule::class))
interface AppComponent {
    fun inject(application: OpenWeatherKotlinApplication)
}