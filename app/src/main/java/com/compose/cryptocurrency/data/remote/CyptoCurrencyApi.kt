package com.compose.cryptocurrency.data.remote

import com.compose.cryptocurrency.data.remote.dto.CoinDetailDto
import com.compose.cryptocurrency.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CyptoCurrencyApi {

    @GET(ApiConstant.API_GET_COIN)
    suspend fun getAllCoins(): List<CoinDto>

    @GET(ApiConstant.API_GET_COIN_DETAIL+ "{coinId}")
    suspend fun getCoinById(@Path(ApiConstant.COIN_ID) coinId: String): CoinDetailDto
}
