package io.treeapps.project.android_mvi_orbit.viewmodel

sealed class WeatherIntent {
    data class LoadWeather(val cityName: String) : WeatherIntent()
}