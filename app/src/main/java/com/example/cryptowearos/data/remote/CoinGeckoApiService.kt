package com.example.cryptowearos.data.remote

import com.example.cryptowearos.domain.model.ExchangeRateResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinGeckoApiService {
    @GET("simple/price")
    suspend fun getCurrentExchangeRate(
        @Query("ids") id: String = "bitcoin",
        @Query("vs_currencies") currency: String = "eur"
    ): ExchangeRateResponse
}