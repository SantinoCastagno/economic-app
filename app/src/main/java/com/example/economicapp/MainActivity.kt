package com.example.economicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import com.example.economicapp.presentation.navigation.Navigation
import com.example.economicapp.presentation.components.DollarHisViewModel
import com.example.economicapp.presentation.components.DollarHisViewModelFactory
import com.example.economicapp.presentation.components.DollarViewModel
import com.example.economicapp.presentation.components.DollarViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: DollarViewModel by viewModels {
                DollarViewModelFactory(
                    (this.applicationContext as DollarApplication).database.dollarDao(),
                    (this.applicationContext as DollarApplication).database.dollarHistoricalDao(),
                )
            }
            val viewModelHis: DollarHisViewModel by viewModels {
                DollarHisViewModelFactory(
                    (this.applicationContext as DollarApplication).database.dollarHistoricalDao(),
                )
            }
            Surface(color = MaterialTheme.colors.background) {
                Navigation(viewModel, viewModelHis)
            }
        }
    }
}
