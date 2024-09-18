package io.treeapps.project.domain.entity

data class Weather(
    val cityName: String,
    val temperature: Double,
    val weatherDescription: String,
    val minTemperature: Double,
    val maxTemperature: Double
)