package com.compose.cryptocurrency.domain.repository

import com.compose.cryptocurrency.data.remote.dto.CoinDetailDto
import com.compose.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getAllCoins(): List<CoinDto>
    suspend fun getCoinsById(coinId: String): CoinDetailDto
}