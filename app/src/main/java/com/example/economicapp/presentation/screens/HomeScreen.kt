package com.example.economicapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.economicapp.R
import com.example.economicapp.DollarViewModel
import com.example.economicapp.model.Dollar
import com.example.economicapp.navigation.Screen
import com.example.economicapp.presentation.ui.theme.Black
import com.example.economicapp.presentation.ui.theme.Grey

@Composable
fun HomeScreen(navController: NavController, viewModel: DollarViewModel){
    val isLoading = viewModel.isLoading().observeAsState(false)
    val lastDollar = viewModel.status().observeAsState(Dollar("","",""))

    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("PANTALLA INICIAL")
                    if (isLoading.value){
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(horizontal = 15.dp)
                                .width(40.dp),
                            color = Grey,
                            strokeWidth = (2.8).dp,
                        )
                    }

                }
            }
        ) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight(0.9f)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround,
                ) {
                    Box(
                        modifier = Modifier.weight(0.3f),
                        contentAlignment = Alignment.Center
                    ) {
                        LastDollarCard(
                            loadingValue = isLoading.value,
                            dollarValue = lastDollar.value
                        )
                    }
                    Box(
                        modifier = Modifier.weight(0.5f),
                        contentAlignment = Alignment.Center
                    ){
                        EconomicImage()
                    }
                    Box(
                        modifier = Modifier.weight(0.15f),
                        contentAlignment = Alignment.Center
                    ) {
                        NavigationButton(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun LastDollarCard(loadingValue: Boolean, dollarValue: Dollar){
    Card(
        elevation = 30.dp,
        shape = RoundedCornerShape(10.dp),
        contentColor = Color.DarkGray,
        modifier = Modifier
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .fillMaxHeight(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            if(!loadingValue){
                Box(modifier = Modifier.weight(0.40f),
                contentAlignment = Alignment.Center){
                    Text(text = "Actualizado: ${dollarValue.fecha}")
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.weight(0.60f).fillMaxWidth(),
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Compra")
                        Text(text = "$" + dollarValue.compra)
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(text = "Venta")
                        Text(text = "$" + dollarValue.venta)
                    }
                }
            }
        }
    }
}

@Composable
fun EconomicImage(){
    Box(modifier = Modifier.padding(20.dp)){
        Image(
            painter = painterResource(id = R.drawable.personal_finance),
            contentDescription = "Figura representativa del dinero",
            modifier = Modifier
                .height(200.dp)
                .width(900.dp)
        )
    }
}

@Composable
fun NavigationButton(navController: NavController){
    Button(
        modifier = Modifier
            .padding(10.dp)
            .border(width = 1.dp, color = Black),
        onClick = {navController.navigate(Screen.HistoricDollarScreen.route) }) {
        Text(text = "CONSULTAR HISTORICO")
    }
}

// To visualize elements: .border(width = 2.dp, color = Red)