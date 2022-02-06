package com.example.economicapp.database

import androidx.room.*
import com.example.economicapp.model.Dollar
import kotlinx.coroutines.flow.Flow

@Dao
interface DollarDao {
    @Query("SELECT * FROM dollar")
    suspend fun getDollar(): Dollar

    @Query("DELETE FROM dollar")
    suspend fun deleteDollar()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDollar(dollar: Dollar)
}