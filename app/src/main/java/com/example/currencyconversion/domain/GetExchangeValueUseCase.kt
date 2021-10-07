package com.example.currencyconversion.domain

import com.example.currencyconversion.core.UseCase
import com.example.currencyconversion.data.model.ExchangeResponseValue
import com.example.currencyconversion.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class GetExchangeValueUseCase(
    private val repository: CoinRepository
) : UseCase<String, ExchangeResponseValue>() {

    override suspend fun execute(param: String): Flow<ExchangeResponseValue> {
        return repository.getExchangeValue(param)
    }
}