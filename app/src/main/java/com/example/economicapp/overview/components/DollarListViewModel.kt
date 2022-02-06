package com.example.economicapp.overview.components

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.economicapp.model.DollarHistorical

const val PAGE_SIZE = 10

class DollarListViewModel {
    private val historical: MutableState<List<DollarHistorical>> = mutableStateOf(emptyList())
    private val page = mutableStateOf(1)
    private val loadingPage = mutableStateOf(false)
    private var  dollarListScrollPosition = 0

    private fun incrementPage(){
        page.value = page.value + 1;
    }

    private fun onChangeDollarScrollPosition(position: Int){
        dollarListScrollPosition = position
    }

    private fun appendDollarValues(newDollars: List<DollarHistorical>){
        val current = ArrayList(this.historical.value)
        current.addAll(newDollars)
        this.historical.value = current
    }

    private fun nextPage(){
        if (dollarListScrollPosition + 1 >= page.value * PAGE_SIZE ){
            loadingPage.value = true

            if (page.value > 1){
                //TODO: se hace la solicitud al modelo aqui
            }

            loadingPage.value = false
        }
    }
}