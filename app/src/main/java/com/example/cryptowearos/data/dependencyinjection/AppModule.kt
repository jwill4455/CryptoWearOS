package com.example.cryptowearos.data.dependencyinjection

import com.example.cryptowearos.data.remote.CoinGeckoApiService
import com.example.cryptowearos.data.repository.ExchangeRateRepositoryImpl
import com.example.cryptowearos.domain.repository.ExchangeRateRepository
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
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): CoinGeckoApiService {
        return retrofit.create(CoinGeckoApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideExchangeRateRepository(
        apiService: CoinGeckoApiService
    ): ExchangeRateRepository {
        return ExchangeRateRepositoryImpl(apiService)
    }
}