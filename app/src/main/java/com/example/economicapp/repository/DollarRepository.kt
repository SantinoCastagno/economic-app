package com.example.economicapp.repository

import android.util.Log
import com.example.economicapp.database.DollarDao
import com.example.economicapp.database.DollarHistoricalDao
import com.example.economicapp.model.Dollar
import com.example.economicapp.model.DollarHistorical
import com.example.economicapp.network.DollarApi
import java.lang.Exception

class DollarRepository {

    suspend fun getDollar(dollarDao: DollarDao): Dollar {
        var dollar: Dollar
        try {
            dollar = DollarApi.retrofitService.getDollar()
            dollarDao.deleteDollar()
            dollarDao.insertDollar(dollar)
        } catch (e: Exception) {
            Log.e("ERROR", "Failure: ${e.message}")
            dollar = dollarDao.getDollar()
        }
        return dollar
    }

    suspend fun getHistorical(
        dollarHistoricalDao: DollarHistoricalDao,
        init: Int,
        fin: Int
    ): List<DollarHistorical> {
        var dollarHistorical: List<DollarHistorical>
        try {
            dollarHistorical = DollarApi.retrofitService.getHistorical()
            dollarHistoricalDao.deleteHistoricalDollar()
            dollarHistoricalDao.insertDollarHistorical(dollarHistorical)
        } catch (e: Exception) {
            Log.e("ERROR", "Failure: ${e.message}")
        } finally {
            dollarHistorical = dollarHistoricalDao.getHistorical(init, fin)
        }
        return dollarHistorical
    }

}

