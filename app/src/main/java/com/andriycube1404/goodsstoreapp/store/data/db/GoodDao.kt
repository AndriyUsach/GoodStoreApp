package com.andriycube1404.goodsstoreapp.store.data.db

import androidx.room.*
import com.andriycube1404.goodsstoreapp.store.data.entities.GoodEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GoodDao {

    @Query("SELECT * FROM GoodEntity")
    fun getAllGood(): Flow<List<GoodEntity>>

    @Query("SELECT * FROM GoodEntity ORDER BY good_series")
    fun getAllGoodSortedBySeries(): Flow<List<GoodEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGood(good: GoodEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGood(goods: List<GoodEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateGood(good: GoodEntity)

    @Delete
    suspend fun deleteGood(good: GoodEntity)

}