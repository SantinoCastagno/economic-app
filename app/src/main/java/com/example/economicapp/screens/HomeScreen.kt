package com.example.economicapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.example.economicapp.navigation.Screen

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
            title = {
                Text("Inicio" )
            }
        ) }
    ) {
        //TODO: Una vez que se terminen de acomodar hay que eliminar los colores de los background
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color.Red),
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Column(
                //TODO: Agregar padding top en vez de centrar automaticamente
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Green),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column(
                    modifier = Modifier
                        .height(Dp(200f))
                        .background(color = Color.Gray),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Button(
                        onClick = { navController.navigate(Screen.LastDollarScreen.route){} }) {
                        Text(text = "Consultar precio actual")
                    }
                    Button(
                        onClick = { navController.navigate(Screen.HistoricDollarScreen.route) }) {
                        Text(text = "Consultar historico")
                    }
                    // TODO: configurar una de las imagenes de los assets usando el modulo "coil"
                    // Image(painter = rememberImagePainter(), contentDescription = )
                }

                //TODO: agregar una animacion para que el usuario visualice la descarga de datos
            }
        }
    }
}

//TODO: Este metodo deberia funcionar para dibujar una imagen, pero no detecta el "drawable"
//@Composable
//fun SimpleImage() {
//    Image(
//        painter = painterResource(id = R.drawable.personal_finance_1),
//        contentDescription = "Figura representativa del dinero",
//        modifier = Modifier.fillMaxWidth()
//    )
//}
