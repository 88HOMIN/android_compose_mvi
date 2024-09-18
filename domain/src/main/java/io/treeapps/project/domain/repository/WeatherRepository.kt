package io.treeapps.project.domain.repository

import io.treeapps.project.domain.entity.Weather

interface WeatherRepository {
    suspend fun getWeatherByCity(cityName: String): Weather
}