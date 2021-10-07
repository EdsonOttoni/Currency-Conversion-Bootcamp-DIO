package com.example.currencyconversion.data.repository

import com.example.currencyconversion.data.model.ExchangeResponseValue
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    suspend fun getExchangeValue(coins: String): Flow<ExchangeResponseValue>
}