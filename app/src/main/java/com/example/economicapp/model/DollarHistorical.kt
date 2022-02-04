package com.example.economicapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dollarHistorical")
data class DollarHistorical(
    @ColumnInfo(name = "valor")         val valor: String,
    @ColumnInfo(name = "date")          val date: String,
    @PrimaryKey(autoGenerate = true)    val id: Int = 0
)