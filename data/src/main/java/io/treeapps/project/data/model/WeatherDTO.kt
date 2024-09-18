package io.treeapps.project.data.model


data class WeatherDTO(
    val name: String, // 도시 이름
    val main: Main,
    val weather: List<WeatherDescription>
)

data class Main(
    val temp: Double, // 현재 온도 (켈빈)
    val feels_like: Double, // 체감 온도
    val temp_min: Double, // 최저 온도
    val temp_max: Double, // 최고 온도
    val pressure: Int, // 기압
    val humidity: Int // 습도
)

data class WeatherDescription(
    val description: String // 날씨 설명 (예: clear sky)
)