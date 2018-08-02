package com.example.rubinathapa.openweatherkotlin.ui.weather.mvvm

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rubinathapa.openweatherkotlin.R
import com.example.rubinathapa.openweatherkotlin.data.Entity.GetWeatherResponse
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.weather_fragment.*
import timber.log.Timber
import javax.inject.Inject

class WeatherFragment : Fragment() {
    @Inject
    lateinit var weatherViewModel: WeatherViewModel

    lateinit var navigationListener: NavigationListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.weather_fragment, container, false)
        AndroidSupportInjection.inject(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherViewModel.weatherDataResult()
        weatherViewModel.weatherDataResult?.observe(this, Observer<GetWeatherResponse> {
            if (it != null) {
                weather_fragment_main_textview.text = it!!.weather!![0].main
                weather_fragment_description_textview.text = it!!.weather!![0].description
                Timber.i("datalllllllllllllllllllllllllllllllllllllllllllllllll:" + it!!.weather!![0].main)
            }
        })

        weatherViewModel.weatherDataError().observe(this, Observer<String>
        {
            weather_fragment_main_textview.text = it!!
        })
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        navigationListener = context as NavigationListener
    }

    interface NavigationListener {
        fun weatherFragmentOnResume()
    }
}