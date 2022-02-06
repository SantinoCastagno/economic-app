package com.example.economicapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.economicapp.model.Dollar
import com.example.economicapp.model.DollarHistorical

@Database(entities = [Dollar::class, DollarHistorical::class], version = 1, exportSchema = false)
abstract class DollarRoomDatabase : RoomDatabase() {
    abstract fun dollarDao(): DollarDao
    abstract fun dollarHistoricalDao(): DollarHistoricalDao

    companion object {
        @Volatile
        private var INSTANCE: DollarRoomDatabase? = null
        fun getDatabase(context: Context): DollarRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DollarRoomDatabase::class.java,
                    "dollar_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}