package com.example.economicapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import androidx.compose.ui.Modifier
import com.example.economicapp.network.Dollar
import com.example.economicapp.network.DollarHistorical
import com.example.economicapp.overview.OverviewViewModel

@Composable
fun HistoricDollarScreen(navController: NavController, viewModel: OverviewViewModel){
    val historical: List<DollarHistorical> by viewModel.statusHistorical().observeAsState(emptyList())
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Valores del mes" ) //${historical[20].valor}
                }
            ) }
    ){
        // TODO: Diseniar y definir pantalla utilizando "Scaffold","LazyColumn" y "Card"
        Column {
            Text(
                "El tamaño de la lista es: ${historical.size}"
            )
            LazyColumn(
            ) {
                items(
                    items = historical
                    itemContent = { dollar ->
                        DollarValueCard()
                    }
                ){}
            }
        }
    }
}

@Composable
fun DollarValueCard() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(shape = RoundedCornerShape(5.dp), modifier = paddingModifier) {
        Text(text = "Round corner shape")
    }
}



