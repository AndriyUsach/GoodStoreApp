package com.andriycube1404.goodsstoreapp.store.data.repositories

import com.andriycube1404.goodsstoreapp.store.domain.model.Good
import kotlinx.coroutines.flow.Flow


interface GoodsLocalDataSource {

    suspend fun getAllGoods(): Flow<List<Good>>

    suspend fun getAllGoodsSortedBySeries(): Flow<List<Good>>

    suspend fun insertGood(good: Good)

    suspend fun insertGood(goods: List<Good>)

    suspend fun updateGood(good: Good)

    suspend fun deleteGood(good: Good)
}