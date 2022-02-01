package com.example.economicapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.economicapp.network.DollarHistorical
import com.example.economicapp.overview.OverviewViewModel
import com.example.economicapp.screens.HistoricDollarScreen
import com.example.economicapp.screens.HomeScreen
import com.example.economicapp.screens.LastDollarScreen

@Composable
fun Navigation(viewModel: OverviewViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LastDollarScreen.route){
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screen.LastDollarScreen.route) {
            LastDollarScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screen.HistoricDollarScreen.route) {
            HistoricDollarScreen(navController = navController, viewModel = viewModel)
        }
    }
}

sealed class Screen(val route: String){
    object HomeScreen : Screen("home_screen")
    object HistoricDollarScreen : Screen("historic_dollar_screen")
    object LastDollarScreen: Screen("last_dollar_screen")
}
