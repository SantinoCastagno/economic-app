package com.example.economicapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.ui.platform.LocalContext
import com.example.economicapp.ui.theme.EconomicAppTheme
import com.example.economicapp.navigation.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: DollarViewModel by viewModels {
                DollarViewModelFactory(
                    (this.applicationContext as DollarApplication).database.dollarDao(),
                    (this.applicationContext as DollarApplication).database.dollarHistoricalDao()
                )
            }
            EconomicAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation(viewModel)
                }
            }
        }
    }
}
