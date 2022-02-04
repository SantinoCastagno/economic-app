package com.example.economicapp.model

import androidx.room.*

@Entity(tableName = "dollar")
data class Dollar(
    @ColumnInfo(name = "fecha")         val fecha: String,
    @ColumnInfo(name = "compra")        val compra: String,
    @ColumnInfo(name = "venta")         val venta: String,
    @PrimaryKey(autoGenerate = true)    val id: Int = 0
)
