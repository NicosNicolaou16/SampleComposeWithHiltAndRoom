package com.nick.samplecomposewithhiltandroom.utils.remote.network

import com.nick.samplecomposewithhiltandroom.utils.remote.ship_service.ShipService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ShipsModules {
    private const val BASE_URL = "https://api.spacexdata.com"

    @Provides
    @Singleton
    fun getShipsList(retrofit: Retrofit): ShipService {
        return retrofit.create(ShipService::class.java)
    }

    @Provides
    @Singleton
    fun requestBuilder(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}