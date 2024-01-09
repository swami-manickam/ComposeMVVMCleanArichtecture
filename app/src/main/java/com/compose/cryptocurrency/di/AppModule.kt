package com.compose.cryptocurrency.di

import com.compose.cryptocurrency.common.AppConstants
import com.compose.cryptocurrency.data.remote.CyptoCurrencyApi
import com.compose.cryptocurrency.data.repository.CoinRepositoryImpl
import com.compose.cryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CyptoCurrencyApi {
        return Retrofit.Builder().baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CyptoCurrencyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CyptoCurrencyApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}