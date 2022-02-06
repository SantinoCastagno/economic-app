package com.example.economicapp

import android.util.Log
import androidx.lifecycle.*
import com.example.economicapp.database.DollarDao
import com.example.economicapp.database.DollarHistoricalDao
import com.example.economicapp.network.DollarApi
import com.example.economicapp.model.Dollar
import com.example.economicapp.model.DollarHistorical
import com.example.economicapp.repository.DollarRepository
import kotlinx.coroutines.launch


class DollarViewModel(
    private val dollarDao: DollarDao,
    private val dollarHistoricalDao: DollarHistoricalDao
) : ViewModel() {

    private var dollarRepo: DollarRepository

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<Dollar>()
    private val _statusHistorical = MutableLiveData<List<DollarHistorical>>()
    private val _loading = MutableLiveData(false)

    // The external immutable LiveData for the request status
    fun status(): LiveData<Dollar> = _status
    fun statusHistorical(): LiveData<List<DollarHistorical>> = _statusHistorical
    fun isLoading(): LiveData<Boolean> = _loading

    init {
        dollarRepo = DollarRepository()
        getDollar()
        getHistorical()
    }

    private fun getDollar() {
        viewModelScope.launch {
            try {
                _loading.postValue(true)
                val dollarResult = dollarRepo.getDollar(dollarDao)
                _status.value = dollarResult
                _loading.postValue(false)
            } catch (e: Exception) {
                Log.e("ERROR", "Failure: ${e.message}")
            }
        }
    }

    private fun getHistorical() {
        viewModelScope.launch {
            try {
                _loading.postValue(true)
                val historical = dollarRepo.getHistorical(dollarHistoricalDao)
                _statusHistorical.value = historical
                _loading.postValue(false)
            } catch (e: Exception) {
                Log.e("ERROR","Failure: ${e.message}")
            }
        }
    }
}

class DollarViewModelFactory(
    private val dollarDao: DollarDao,
    private val dollarHistoricalDao: DollarHistoricalDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DollarViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DollarViewModel(dollarDao, dollarHistoricalDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}