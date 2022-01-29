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
import com.example.economicapp.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel: OverviewViewModel by viewModels()
            val currentValue by viewModel.status().observeAsState("")
            val historical by viewModel.statusHistorical().observeAsState(emptyList())

            EconomicAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                    //Text(text = "${historical.size}")
                }
            }
        }
    }
}
