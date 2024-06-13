package com.example.cryptowearos.data.repository

import com.example.cryptowearos.data.remote.CoinGeckoApiService
import com.example.cryptowearos.domain.repository.ExchangeRateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExchangeRateRepositoryImpl @Inject constructor(private val apiService: CoinGeckoApiService) :
    ExchangeRateRepository {

    override fun getCurrentExchangeRate(): Flow<Double> = flow {
        val response = apiService.getCurrentExchangeRate()
        emit(response.bitcoin["eur"] ?: 0.0)
    }
}