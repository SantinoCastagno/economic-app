package com.example.economicapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.economicapp.screens.navigation.Screen

import com.example.economicapp.R
import com.example.economicapp.network.Dollar
import com.example.economicapp.overview.OverviewViewModel
import com.example.economicapp.ui.theme.Black
import com.example.economicapp.ui.theme.Grey

@Composable
fun HomeScreen(navController: NavController, viewModel: OverviewViewModel){
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
        //TODO: Unificar LastDollarScreen y el HomeScreen
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
                        .height(Dp(400f)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround,
                ) {
                    Box(modifier = Modifier.width(250.dp).height(100.dp).border(width = 2.dp, color = Black))
                    {
                        if(!isLoading.value){
                            Text(text = "Actualizado a ${lastDollar.value.fecha}")
                            Row() {
                                Column() {

                                }
                                Column() {

                                }
                            }
                        }
                    }
                    Box(modifier = Modifier.padding(20.dp)){//.border(width = 2.dp, color = Black)){
                        Image(
                            painter = painterResource(id = R.drawable.personal_finance),
                            contentDescription = "Figura representativa del dinero",
                            modifier = Modifier
                                .height(200.dp)
                                .width(900.dp)
                        )
                    }
                    Button(
                        modifier = Modifier
                            .padding(10.dp)
                            .border(width = 1.dp, color = Black),
                        onClick = { navController.navigate(Screen.HistoricDollarScreen.route) }) {
                        Text(text = "CONSULTAR HISTORICO")
                    }
                }
            }
        }
    }
}

