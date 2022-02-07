package com.example.economicapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.economicapp.DollarViewModel
import com.example.economicapp.presentation.components.DollarListViewModel
import com.example.economicapp.presentation.screens.HistoricDollarScreen
import com.example.economicapp.presentation.screens.HomeScreen

@Composable
fun Navigation(viewModel: DollarViewModel, viewModelHis: DollarListViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screen.HistoricDollarScreen.route) {
            HistoricDollarScreen(navController = navController, viewModel = viewModel,  viewModelHis = viewModelHis)
        }
    }
}

sealed class Screen(val route: String){
    object HomeScreen : Screen("home_screen")
    object HistoricDollarScreen : Screen("historic_dollar_screen")
    object LastDollarScreen: Screen("last_dollar_screen")
}
