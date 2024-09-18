package io.treeapps.project.android_mvi_orbit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.treeapps.project.data.network.WeatherApiService
import io.treeapps.project.data.repository.WeatherRepositoryImpl
import io.treeapps.project.domain.repository.WeatherRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(
        apiService: WeatherApiService,
        apiKey: String
    ): WeatherRepository {
        return WeatherRepositoryImpl(apiService, apiKey)
    }

    @Provides
    @Singleton
    fun provideApiKey(): String {
        return "7d5f56fd1704c095bcf82325c464270f" // BuildConfig에서 API 키를 가져올 것...
    }
}