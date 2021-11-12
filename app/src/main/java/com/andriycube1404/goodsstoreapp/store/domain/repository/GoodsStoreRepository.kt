package com.andriycube1404.goodsstoreapp.store.domain.repository

import com.andriycube1404.goodsstoreapp.store.domain.model.Good
import kotlinx.coroutines.flow.Flow

interface GoodsStoreRepository {

    suspend fun getGoods(): Flow<List<Good>>

    suspend fun getGoodsSortedBySeries(): Flow<List<Good>>

}