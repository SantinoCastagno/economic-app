package com.example.economicapp.overview

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.economicapp.network.Dollar
import com.example.economicapp.network.DollarApi
import com.example.economicapp.network.DollarHistorical
import kotlinx.coroutines.launch


class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<Dollar>()
    private val _statusHistorical = MutableLiveData<List<DollarHistorical>>()
    private val _loading = MutableLiveData(false)

    // The external immutable LiveData for the request status
    fun status(): LiveData<Dollar> = _status
    fun statusHistorical(): LiveData<List<DollarHistorical>> = _statusHistorical
    fun isLoading(): LiveData<Boolean> = _loading

    init {
        getDollar()
        getHistorical()
    }

    //TODO: Corregir funciones al utilizar la clase Repository
    private fun getDollar() {
        viewModelScope.launch {
            try {
                _loading.postValue(true)
                val dollarResult = DollarApi.retrofitService.getDollar()
                _status.value = dollarResult
                _loading.postValue(false)
            } catch (e: Exception) {
                println("Failure: ${e.message}")
            }
        }
    }

    private fun getHistorical() {
        viewModelScope.launch {
            try {
                _loading.postValue(true)
                val historical = DollarApi.retrofitService.getHistorical()
                _statusHistorical.value = historical
                _loading.postValue(false)
            } catch (e: Exception) {
                println("Failure: ${e.message}")
            }
        }
    }
}