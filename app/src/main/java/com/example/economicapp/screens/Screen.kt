package com.example.economicapp.screens

sealed class Screen(val route: String){
    object HomeScreen : Screen("home_screen")
    object HistoricDollarScreen : Screen("historic_dollar_screen")
    object LastDollarScreen: Screen("last_dollar_screen")
}
