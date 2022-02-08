package com.example.economicapp.presentation.components

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.economicapp.database.DollarHistoricalDao
import com.example.economicapp.model.DollarHistorical
import com.example.economicapp.repository.DollarRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val PAGE_SIZE = 5

class DollarHisViewModel(private val dollarHistoricalDao: DollarHistoricalDao) : ViewModel() {

    private var dollarRepo: DollarRepository

    // The internal MutableLiveData that stores the status of the most recent request
    private val _statusHistorical = MutableLiveData<List<DollarHistorical>>()
    private val _loading = MutableLiveData(false)

    // The external immutable LiveData for the request status
    fun statusHistorical(): LiveData<List<DollarHistorical>> = _statusHistorical
    fun isLoading(): LiveData<Boolean> = _loading

    // Pagination starts at '1'
    val page = mutableStateOf(1)
    private var listScrollPosition = 0

    init {
        dollarRepo = DollarRepository()
        getHistorical()
    }

    private fun getHistorical() {
        viewModelScope.launch {
            try {
                _loading.postValue(true)
                val historical = dollarRepo.getHistorical(dollarHistoricalDao, 0, PAGE_SIZE)
                _statusHistorical.value = historical
                _loading.postValue(false)
            } catch (e: Exception) {
                Log.e("ERROR", "Failure: ${e.message}")
            }
        }
    }

    fun nextPage() {
        viewModelScope.launch {
            if ((listScrollPosition + 1) >= (page.value * PAGE_SIZE)) {
                _loading.postValue(true)
                incrementPage()

                delay(1000)

                if (page.value > 1) {
                    val result = dollarRepo.getHistorical(
                        dollarHistoricalDao, (page.value - 1) * PAGE_SIZE, PAGE_SIZE
                    )
                    appendDollars(result)
                }
                _loading.postValue(false)
            }
        }
    }

    private fun incrementPage() {
        page.value = page.value + 1
    }

    private fun appendDollars(dollars: List<DollarHistorical>) {
        val current = _statusHistorical.value
        val aux = current?.toMutableList()
        aux?.addAll(dollars)
        _statusHistorical.value = aux!!
    }

    fun onChangeDollarScrollPosition(position: Int) {
        listScrollPosition = position
    }
}

class DollarHisViewModelFactory(
    private val dollarHistoricalDao: DollarHistoricalDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DollarHisViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DollarHisViewModel(dollarHistoricalDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}