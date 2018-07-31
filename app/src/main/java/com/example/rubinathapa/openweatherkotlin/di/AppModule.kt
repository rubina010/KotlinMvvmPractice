package com.example.rubinathapa.openweatherkotlin.di

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.migration.Migration
import com.example.rubinathapa.openweatherkotlin.database.AppDatabase
import com.example.rubinathapa.openweatherkotlin.database.Dao.WeatherDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {
    companion object {
        val MIGRATION_1_2:Migration= object: Migration(1,2)
        {
            override fun migrate(database: SupportSQLiteDatabase) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
    }
    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideWeatherDatabase(app: Application): AppDatabase = Room.databaseBuilder(app,
            AppDatabase::class.java,"weather_db")
            .addMigrations(MIGRATION_1_2)
            .allowMainThreadQueries()
            .build()

    @Provides
    @Singleton
    fun provideWeatherDAO(database: AppDatabase): WeatherDAO = database.weatherDao()
}