package com.example.rubinathapa.openweatherkotlin.di

import com.example.rubinathapa.openweatherkotlin.data.ApiService
import com.google.gson.Gson
import com.google.gson.JsonParser
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
class ApiModule {
    @Inject
    lateinit var gson: Gson

    @Provides
    @Singleton
    fun provideJsonParser(): JsonParser {
        return JsonParser()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder().client(okHttpClient)
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService::class.java)
    }


}