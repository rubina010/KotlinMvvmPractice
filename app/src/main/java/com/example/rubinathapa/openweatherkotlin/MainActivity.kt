package com.example.rubinathapa.openweatherkotlin

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.rubinathapa.openweatherkotlin.data.Entity.GetWeatherResponse
import com.example.rubinathapa.openweatherkotlin.ui.weather.mvvm.WeatherViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var weatherViewModel: WeatherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherViewModel.weatherDataResult()
        weatherViewModel.weatherDataResult?.observe(this, Observer<GetWeatherResponse>{

            if(it!=null)
            {
                activity_main_main_textview.text= it!!.weather!![0].main
                activity_main_description_textview.text=it!!.weather!![0].description

                Timber.i("DATA"+it!!.weather!![0].main+it.weather!![0].description)
            }
        })

        weatherViewModel.weatherDataError().observe(this, Observer<String>
        {
            activity_main_main_textview.text=it!!
        })

    }



}
