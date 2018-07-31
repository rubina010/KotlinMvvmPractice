package com.example.rubinathapa.openweatherkotlin.ui.weather.mvvm

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.rubinathapa.openweatherkotlin.data.Entity.GetWeatherResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class WeatherViewModel @Inject constructor(val context: Application,
                                           val weatherRepository: WeatherRepository,
                                           val compositeDisposable: CompositeDisposable
) : AndroidViewModel(context) {
    var weatherDataResult: LiveData<GetWeatherResponse>? = null

    var weatherDataError: MutableLiveData<String> = MutableLiveData()


    fun weatherDataResult() {

        compositeDisposable.add(weatherRepository.getDataFromServer()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy {
                    weatherRepository.saveInDatabase(it)
                    Timber.i("DATA" + it)
                }
        )
        weatherDataResult = weatherRepository.getWeatherDataFromDb()
        Timber.i("data"+weatherDataResult)


        /*.subscribeOn(Schedulers.newThread())
        .observerOn(AndroidSchedulers.mainThread())
        .subscribeBy(onNext=
        {
            doASync {
                weatherRepository.saveInDatabase(it)
            }
            })*/
    }

    fun weatherDataError(): LiveData<String> {
        return weatherDataError
    }


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    /* fun disposeElements() {
         if (null != disposableObserver && !disposableObserver.isDisposed)
             disposableObserver.dispose()
     }*/
}