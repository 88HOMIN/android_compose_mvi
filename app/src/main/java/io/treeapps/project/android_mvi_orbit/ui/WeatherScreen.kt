package io.treeapps.project.android_mvi_orbit.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import io.treeapps.project.android_mvi_orbit.viewmodel.WeatherIntent
import io.treeapps.project.android_mvi_orbit.viewmodel.WeatherViewModel
import io.treeapps.project.domain.entity.Weather


@Composable
fun WeatherScreen(viewModel: WeatherViewModel = hiltViewModel()) {
    // Orbit MVI의 State를 관찰합니다.
    val state = viewModel.container.stateFlow.collectAsState()

    // 첫 화면 로딩 시 WeatherIntent.LoadWeather("Seoul") 호출
    LaunchedEffect(Unit) {
        viewModel.handleIntent(WeatherIntent.LoadWeather("Seoul"))
    }

    // UI를 상태에 따라 업데이트
    Column(modifier = Modifier.padding(16.dp)) {
        // 로딩 상태 처리
        if (state.value.isLoading) {
            Text(text = "Loading...")
        }

        // 날씨 정보가 있으면 화면에 표시
        state.value.weather?.let {
            WeatherItem(it)
        }

        // 에러 메시지가 있으면 화면에 표시
        state.value.errorMessage?.let {
            Text(text = "Error: $it")
        }

        // 사용자가 직접 날씨 정보를 로드하는 버튼
        Button(onClick = { viewModel.handleIntent(WeatherIntent.LoadWeather("Seoul")) }) {
            Text(text = "Refresh Weather")
        }
    }
}

@Composable
fun WeatherItem(weather: Weather) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "City: ${weather.cityName}")
        Text(text = "Temperature: ${weather.temperature}°C")
        Text(text = "Description: ${weather.weatherDescription}")
        Text(text = "Min Temp: ${weather.minTemperature}°C")
        Text(text = "Max Temp: ${weather.maxTemperature}°C")
    }
}
