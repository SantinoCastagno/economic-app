package com.example.economicapp.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import com.example.economicapp.model.DollarHistorical
import com.example.economicapp.presentation.components.DollarHisViewModel
import com.example.economicapp.presentation.components.PAGE_SIZE
import com.example.economicapp.presentation.ui.theme.Red

@Composable
fun HistoricDollarScreen(navController: NavController, viewModelHis: DollarHisViewModel) {
    val historical: List<DollarHistorical> by viewModelHis.statusHistorical()
        .observeAsState(emptyList())
    val isLoading by viewModelHis.isLoading().observeAsState(false)
    val page = viewModelHis.page.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Valores del último mes")
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn {
                itemsIndexed(
                    items = historical
                ) { index, dollar ->
                    viewModelHis.onChangeDollarScrollPosition(index)
                    if ((index + 1) >= (page * PAGE_SIZE) && !isLoading) {
                        viewModelHis.nextPage()
                    }
                    DollarCard(dollar.date, dollar.valor)
                }
            }
            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    CircularProgressIndicator(
                        color = Red,
                        strokeWidth = (2.8).dp,
                    )
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "${date}:")
            Text(text = "$${value}")
        }
    }
}



