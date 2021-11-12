package com.andriycube1404.goodsstoreapp.store.data.repositories

import android.content.Context
import com.andriycube1404.goodsstoreapp.store.data.db.GoodDao
import com.andriycube1404.goodsstoreapp.store.data.mappers.toGood
import com.andriycube1404.goodsstoreapp.store.data.mappers.toGoodEntity
import com.andriycube1404.goodsstoreapp.store.domain.model.Good
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GoodsLocalDataSourceImpl(
    private val goodDao: GoodDao,
    private val context: Context
) : GoodsLocalDataSource {
    override suspend fun getAllGoods(): Flow<List<Good>> {
        val entities = goodDao.getAllGood()
        return entities.map { it.map { entity -> entity.toGood(context) } }
    }

    override suspend fun getAllGoodsSortedBySeries(): Flow<List<Good>> {
        val entities = goodDao.getAllGoodSortedBySeries()
        return entities.map { it.map { entity ->  entity.toGood(context) } }
    }

    override suspend fun insertGood(good: Good) {
        val entity = good.toGoodEntity()
        goodDao.insertGood(entity)
    }

    override suspend fun insertGood(goods: List<Good>) {
        val entities = goods.map { it.toGoodEntity() }
        goodDao.insertGood(entities)
    }

    override suspend fun updateGood(good: Good) {
        val entity = good.toGoodEntity()
        goodDao.updateGood(entity)
    }

    override suspend fun deleteGood(good: Good) {
        val entity = good.toGoodEntity()
        goodDao.deleteGood(entity)
    }
}