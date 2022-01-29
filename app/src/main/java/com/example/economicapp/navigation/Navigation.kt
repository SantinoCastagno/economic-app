package com.example.economicapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.economicapp.screens.HistoricDollarScreen
import com.example.economicapp.screens.HomeScreen
import com.example.economicapp.screens.LastDollarScreen
import com.example.economicapp.screens.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.LastDollarScreen.route) {
            LastDollarScreen(navController = navController)
        }
        composable(route = Screen.HistoricDollarScreen.route) {
           HistoricDollarScreen(navController = navController)
        }
    }
}