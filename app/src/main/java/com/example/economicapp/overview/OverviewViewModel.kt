package com.example.economicapp.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.economicapp.network.DollarApi
import com.example.economicapp.network.DollarHistorical
import kotlinx.coroutines.launch


class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
    private val _statusHistorical = MutableLiveData<List<DollarHistorical>>()

    // The external immutable LiveData for the request status
    fun status(): LiveData<String> = _status
    fun statusHistorical(): LiveData<List<DollarHistorical>> = _statusHistorical

    init {
        getDollar()
        getHistorical()
    }

    private fun getDollar() {
        viewModelScope.launch {
            try {
                val dollarResult = DollarApi.retrofitService.getDollar()
                _status.value = dollarResult.compra
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

    private fun getHistorical() {
        viewModelScope.launch {
            try {
                val historical = DollarApi.retrofitService.getHistorical()
                _statusHistorical.value = historical
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}