package io.treeapps.project.android_mvi_orbit.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.treeapps.project.domain.usecase.GetWeatherByCityUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherByCityUseCase: GetWeatherByCityUseCase
) : ViewModel(), ContainerHost<WeatherState, Nothing> {

    // Orbit MVI의 container 설정
    override val container = container<WeatherState, Nothing>(WeatherState())

    // 사용자의 Intent를 처리하는 함수
    fun handleIntent(intent: WeatherIntent) {
        when (intent) {
            is WeatherIntent.LoadWeather -> loadWeather(intent.cityName)
        }
    }

    // 날씨 정보를 로드하는 함수
    private fun loadWeather(cityName: String) = intent {
        // 로딩 상태로 변경
        reduce { state.copy(isLoading = true, errorMessage = null) }

        try {
            val weather = getWeatherByCityUseCase(cityName)
            reduce {
                state.copy(
                    weather = weather,
                    isLoading = false,
                    errorMessage = null
                )
            }
        } catch (e: Exception) {
            reduce { state.copy(isLoading = false, errorMessage = e.message) }
        }
    }
}