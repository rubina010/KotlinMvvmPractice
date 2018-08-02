package com.example.rubinathapa.openweatherkotlin.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.rubinathapa.openweatherkotlin.R
import com.example.rubinathapa.openweatherkotlin.ui.weather.mvvm.WeatherFragment
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(),WeatherFragment.NavigationListener {


    /* @Inject
     lateinit var weatherViewModel: WeatherViewModel*/

    @Inject
    lateinit var weatherFragment: WeatherFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .add(R.id.activity_main_container, weatherFragment)
                .addToBackStack("WeatherFragment")
                .commit()

        /*  weatherViewModel.weatherDataResult()
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
*/
    }
    override fun weatherFragmentOnResume() {
        supportFragmentManager.beginTransaction()
                .add(R.id.activity_main_container, weatherFragment)
                .addToBackStack("WeatherFragment")
                .commit()
    }



}
