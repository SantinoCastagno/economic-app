package com.example.economicapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.compose.rememberImagePainter

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
            title = {
                Text("Inicio")
            }
        ) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                Button(
                    onClick = { navController.navigate(Screen.LastDollarScreen.route) }) {
                    Text(text = "Consultar precio actual")
                }
                Button(
                    onClick = { navController.navigate(Screen.HistoricDollarScreen.route) }) {
                    Text(text = "Consultar historico")
                }
                // TODO: configurar una de las imagenes de los assets usando el modulo "coil"
                // Image(painter = rememberImagePainter(), contentDescription = )
            }
        }
    }
}
