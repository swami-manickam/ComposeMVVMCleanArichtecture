package com.compose.cryptocurrency.data.repository

import com.compose.cryptocurrency.data.remote.CyptoCurrencyApi
import com.compose.cryptocurrency.data.remote.dto.CoinDetailDto
import com.compose.cryptocurrency.data.remote.dto.CoinDto
import com.compose.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CyptoCurrencyApi
) : CoinRepository {
    override suspend fun getAllCoins(): List<CoinDto> {
        return api.getAllCoins()
    }

    override suspend fun getCoinsById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}