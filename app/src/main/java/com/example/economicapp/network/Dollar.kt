package com.example.economicapp.network

data class Dollar(
    val fecha: String,
    val compra: String,
    val venta: String
)



data class DollarHistorical(
    val valor: String,
    val date: String,
)