package io.treeapps.project.data.network

import io.treeapps.project.data.model.WeatherDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    suspend fun getWeatherByCity(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String
    ): WeatherDTO
}