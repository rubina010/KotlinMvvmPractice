package com.example.rubinathapa.openweatherkotlin.data.Entity

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import dagger.android.ReleaseReferencesAt
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "weather")
data class GetWeatherResponse(

        @PrimaryKey
        @NotNull
        val id: String,
              val weather: List<Weather>?
)


data class Coord(
        @SerializedName("lon")
        val lon: Double,
        @SerializedName("lat")
        val lat:Double
)


data class Weather(

        @SerializedName("main")
        val main: String,
        @SerializedName("description")
        val description: String
)

data class Main(
        @SerializedName("temp")
        val temp:Double,
        @SerializedName("pressure")
        val pressure:Double,
        @SerializedName("humidity")
        val humidity:Double,
        @SerializedName("temp_min")
        val temp_min:Double,
        @SerializedName("temp_max")
        val temp_max:Double)

data class Wind(
        @SerializedName("speed")
        val speed:Double,
        @SerializedName("deg")
        val deg:Double
)
data class Clouds(
        @SerializedName("all")
        val all:Int
)

data class Sys(
        @SerializedName("type")
        val type:Int,
        @SerializedName("message")
        val message:Double,
        @SerializedName("country")
        val country:String,
        @SerializedName("sunrise")
        val sunrise:Long,
        @SerializedName("sunset")
        val sunset:Long
)