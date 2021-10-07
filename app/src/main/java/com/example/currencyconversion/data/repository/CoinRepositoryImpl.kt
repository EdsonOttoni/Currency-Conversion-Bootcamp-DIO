package com.example.currencyconversion.data.repository

import com.example.currencyconversion.core.exceptions.RemoteException
import com.example.currencyconversion.data.model.ErrorResponse
import com.example.currencyconversion.data.services.AwesomeService
import com.google.gson.Gson
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class CoinRepositoryImpl(
    private val service: AwesomeService
):  CoinRepository {

    override suspend fun getExchangeValue(coins: String) = flow {
        try{
            val exchangeValue = service.exchangeValue(coins)
            val exchange = exchangeValue.values.first()
            emit(exchange)
        }catch (e: HttpException){
            val json = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(json, ErrorResponse::class.java)
            throw RemoteException(errorResponse.message)
        }
    }
}