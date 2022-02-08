package com.example.economicapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.economicapp.model.DollarHistorical

@Dao
interface DollarHistoricalDao {
    @Query("SELECT * FROM dollarHistorical ORDER BY id ASC LIMIT :fin OFFSET :init")
    suspend fun getHistorical(init: Int, fin: Int): List<DollarHistorical>

    @Query("DELETE FROM dollarHistorical")
    suspend fun deleteHistoricalDollar()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDollarHistorical(dollarHistorical: List<DollarHistorical>)
}