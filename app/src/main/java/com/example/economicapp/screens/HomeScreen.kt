package com.example.economicapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.DefaultPathName
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.economicapp.navigation.Screen

import com.example.economicapp.R
import com.example.economicapp.ui.theme.Black
import com.example.economicapp.ui.theme.Teal

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
            title = {
                Text("PANTALLA INICIAL" )
            }
        ) }
    ) {
        //TODO: Una vez que se terminen de acomodar hay que eliminar los colores de los background
        Row(
            modifier = Modifier
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Column(
                //TODO: Agregar padding top en vez de centrar automaticamente
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
                    Button(
                        modifier = Modifier.padding(10.dp).border(width = 1.dp, color = Black),
                        onClick = { navController.navigate(Screen.LastDollarScreen.route){} }) {
                        Text(text = "CONSULTAR PRECIO ACTUAL")
                    }
                    Button(
                        modifier = Modifier.padding(10.dp).border(width = 1.dp, color = Black),
                        onClick = { navController.navigate(Screen.HistoricDollarScreen.route) }) {
                        Text(text = "CONSULTAR HISTORICO")
                    }
                    // TODO: configurar una de las imagenes de los assets usando el modulo "coil"
                    // Image(painter = rememberImagePainter(), contentDescription = )
                    SimpleImage()
                }

                //TODO: agregar una animacion para que el usuario visualice la descarga de datos
            }
        }
    }
}

//TODO: Este metodo deberia funcionar para dibujar una imagen, pero no detecta el "drawable"
@Composable
fun SimpleImage() {
    Box(modifier = Modifier.padding(20.dp)){//.border(width = 2.dp, color = Black)){
        Image(
            painter = painterResource(id = R.drawable.personal_finance_1),
            contentDescription = "Figura representativa del dinero",
            modifier = Modifier.height(Dp(500f))
        )
    }


}

