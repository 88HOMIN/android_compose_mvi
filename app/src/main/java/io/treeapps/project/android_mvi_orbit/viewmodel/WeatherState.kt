package io.treeapps.project.android_mvi_orbit.viewmodel

import io.treeapps.project.domain.entity.Weather

data class WeatherState(
    val weather: Weather? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)