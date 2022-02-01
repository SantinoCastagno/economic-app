package com.example.economicapp.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.economicapp.overview.OverviewViewModel
import com.example.economicapp.ui.theme.Black
import com.example.economicapp.ui.theme.Teal
import java.lang.reflect.Modifier

@Composable
fun LastDollarScreen(navController: NavController, viewModel: OverviewViewModel){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Precio actual" )
                }
            ) }
    ) {
        ValueCard(texto = "El valor de compra es", value = viewModel.status().value.toString())
    }
}

@Composable
fun ValueCard(value: String, texto: String) {
    val paddingModifier = androidx.compose.ui.Modifier.padding(14.dp).border(width = 2.dp, color = Teal)
    Card(
        elevation = 10.dp,
        modifier = paddingModifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = androidx.compose.ui.Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text(text = "${texto}")
            Text(text = "$${value}")
        }
    }
}

