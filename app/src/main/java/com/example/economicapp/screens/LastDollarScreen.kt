package com.example.economicapp.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.economicapp.model.Dollar
import com.example.economicapp.DollarViewModel
import com.example.economicapp.ui.theme.Teal

@Composable
fun LastDollarScreen(navController: NavController, viewModel: DollarViewModel) {
    val isLoading = viewModel.isLoading().observeAsState(false)
    val lastDollar = viewModel.status().observeAsState(Dollar("", "", ""))
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("PRECIO ACTUAL")
                }
            )
        }
    ) {

        if (isLoading.value) {
            Text(text = "Cargando...")
        } else {
            ValueCard(lastDollar.value.compra, lastDollar.value.venta)
        }
    }
}

@Composable
fun ValueCard(compra: String, venta: String) {
    val paddingModifier = androidx.compose.ui.Modifier
        .padding(14.dp)
        .border(width = 2.dp, color = Teal)
    Card(
        elevation = 10.dp,
        modifier = paddingModifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                Text(text = "Compra: ${compra}")
                Text(text = "Venta: ${venta}")
            }
        }
    }
}
