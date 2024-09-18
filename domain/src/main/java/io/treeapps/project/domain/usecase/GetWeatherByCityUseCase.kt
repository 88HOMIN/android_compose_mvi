package io.treeapps.project.domain.usecase

import io.treeapps.project.domain.entity.Weather
import io.treeapps.project.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherByCityUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(cityName: String): Weather {
        return repository.getWeatherByCity(cityName)
    }
}