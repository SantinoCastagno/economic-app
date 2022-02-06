package com.example.economicapp.presentation.screens

import androidx.compose.foundation.layout.*
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
import com.example.economicapp.model.DollarHistorical
import com.example.economicapp.DollarViewModel

@Composable
fun HistoricDollarScreen(navController: NavController, viewModel: DollarViewModel) {
    val historical: List<DollarHistorical> by viewModel.statusHistorical()
        .observeAsState(emptyList())
    val isLoading = viewModel.isLoading().observeAsState(false)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Valores del último mes" ) //${historical[20].valor}
                }
            ) }
    ){
        // TODO: Realizar paginacion para acceder a los nuevos datos
        Column {
            LazyColumn(
            ) {
                items(
                    items = historical
                ){
                    dollar -> 
                    DollarCard(dollar.date, dollar.valor)
                }
            }
        }
    }
}

@Composable
fun DollarCard(date: String, value: String) {
    Card(
        elevation = 15.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(14.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text(text = "${date}:")
            Text(text = "$${value}")
        }
    }
}



