package io.treeapps.project.data.repository

import io.treeapps.project.data.network.WeatherApiService
import io.treeapps.project.domain.entity.Weather
import io.treeapps.project.domain.repository.WeatherRepository


class WeatherRepositoryImpl(
    private val apiService: WeatherApiService,
    private val apiKey: String // API 키 주입
) : WeatherRepository {

    override suspend fun getWeatherByCity(cityName: String): Weather {
        val weatherDTO = apiService.getWeatherByCity(cityName, apiKey)
        return Weather(
            cityName = weatherDTO.name,
            temperature = weatherDTO.main.temp - 273.15, // 켈빈을 섭씨로 변환
            weatherDescription = weatherDTO.weather[0].description,
            minTemperature = weatherDTO.main.temp_min - 273.15,
            maxTemperature = weatherDTO.main.temp_max - 273.15
        )
    }
}
