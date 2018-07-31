package com.example.rubinathapa.openweatherkotlin

import android.app.Activity
import android.app.Application
import com.example.rubinathapa.openweatherkotlin.di.ApiModule
import com.example.rubinathapa.openweatherkotlin.di.AppModule
import com.example.rubinathapa.openweatherkotlin.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class OpenWeatherKotlinApplication: Application(), HasActivityInjector
{

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .apiModule(ApiModule())
                .build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> =activityInjector

}