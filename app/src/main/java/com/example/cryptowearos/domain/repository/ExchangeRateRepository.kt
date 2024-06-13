package com.example.cryptowearos.domain.repository

import kotlinx.coroutines.flow.Flow

interface ExchangeRateRepository {
    fun getCurrentExchangeRate(): Flow<Double>
}