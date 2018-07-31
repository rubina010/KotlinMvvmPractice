package com.example.rubinathapa.openweatherkotlin.ui.di

import android.app.Application
import com.example.rubinathapa.openweatherkotlin.di.scope.ActivityScoped
import com.example.rubinathapa.openweatherkotlin.di.scope.FragmentScoped
import com.example.rubinathapa.openweatherkotlin.ui.weather.mvvm.WeatherRepository
import com.example.rubinathapa.openweatherkotlin.ui.weather.mvvm.WeatherViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class WeatherModule {
   @FragmentScoped
    @Provides
    fun provideViewModel(repository: WeatherRepository, application: Application,
                         compositeDisposable: CompositeDisposable) = WeatherViewModel(application, repository, compositeDisposable)
}
