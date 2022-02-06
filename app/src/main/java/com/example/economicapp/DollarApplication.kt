package com.example.economicapp

import android.app.Application
import com.example.economicapp.database.DollarRoomDatabase

class DollarApplication : Application() {
    val database: DollarRoomDatabase by lazy { DollarRoomDatabase.getDatabase(this) }
}