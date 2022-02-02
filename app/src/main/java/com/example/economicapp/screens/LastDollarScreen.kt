package com.example.economicapp.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.economicapp.R
import com.example.economicapp.network.Dollar
import com.example.economicapp.overview.OverviewViewModel
import com.example.economicapp.ui.theme.Black
import com.example.economicapp.ui.theme.Teal
import java.lang.reflect.Modifier

@Composable
fun LastDollarScreen(navController: NavController, viewModel: OverviewViewModel){
    val isLoading = viewModel.isLoading().observeAsState(false)
    val lastDollar = viewModel.status().observeAsState(Dollar("","",""))
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("PRECIO ACTUAL" )
                }
            ) }
    ) {

        if (isLoading.value){
            Text(text = "Cargando")
        } else {
            ValueCard(texto = "El valor de compra es", value = lastDollar.value.fecha)
        }
    }
}

@Composable
fun ValueCard(value: String, texto: String) {
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
            //Text(text = "${texto}")
            Text(text = "$${value}")
        }
    }
}
