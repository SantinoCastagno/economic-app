package com.example.economicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import com.example.economicapp.overview.OverviewViewModel
import com.example.economicapp.ui.theme.EconomicAppTheme
import com.example.economicapp.screens.navigation.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel:      OverviewViewModel       by viewModels()

            EconomicAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Navigation(viewModel)
                    //Text(text = "${historical.size}")
                }
            }
        }
    }
}
