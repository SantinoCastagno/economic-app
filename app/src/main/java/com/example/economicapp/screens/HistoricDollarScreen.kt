package com.example.economicapp.screens

import androidx.compose.foundation.layout.padding
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
import com.example.economicapp.network.DollarHistorical
import com.example.economicapp.overview.OverviewViewModel

@Composable
fun HistoricDollarScreen(navController: NavController, viewModel: OverviewViewModel){
    val historical: List<DollarHistorical>  by viewModel.statusHistorical().observeAsState(emptyList())
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Valores del mes${historical.size}" )
                }
            ) }
    ){
        // TODO: Diseniar y definir pantalla utilizando "Scaffold","LazyColumn" y "Card"
        CardWithShape()
    }
}

@Composable
fun CardWithShape() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(shape = RoundedCornerShape(5.dp), modifier = paddingModifier) {
        Text(text = "Round corner shape")
    }
}

