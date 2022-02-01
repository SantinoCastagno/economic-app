package com.example.economicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.example.economicapp.overview.OverviewViewModel
import com.example.economicapp.ui.theme.EconomicAppTheme
import androidx.compose.runtime.getValue
import com.example.economicapp.navigation.Navigation
import com.example.economicapp.network.Dollar
import com.example.economicapp.network.DollarHistorical
import com.example.economicapp.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel:      OverviewViewModel       by viewModels()
            val currentValue:   Dollar                  by viewModel.status().observeAsState(Dollar("","",""))
            val historical:     List<DollarHistorical>  by viewModel.statusHistorical().observeAsState(emptyList())

            EconomicAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //TODO: los valores enviados por parametros son los accesibles desde este momento y no funcionan
                    Navigation(viewModel)
                    //Text(text = "${historical.size}")
                }
            }
        }
    }
}
