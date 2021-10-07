package com.example.currencyconversion.data.model

data class ErrorResponse (
    val status: Long,
    val code: String,
    val message: String
)