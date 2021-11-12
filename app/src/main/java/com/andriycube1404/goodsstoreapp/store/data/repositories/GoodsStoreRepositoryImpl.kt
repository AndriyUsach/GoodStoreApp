package com.andriycube1404.goodsstoreapp.store.data.repositories

import com.andriycube1404.goodsstoreapp.store.data.api.FakeAPI
import com.andriycube1404.goodsstoreapp.store.domain.model.Good
import com.andriycube1404.goodsstoreapp.store.domain.repository.GoodsStoreRepository
import com.andriycube1404.goodsstoreapp.store.domain.util.PreferencesKeys
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlin.coroutines.coroutineContext

class GoodsStoreRepositoryImpl(
    private val preferencesDataSource: StorePreferencesDataSource,
    private val localDataSource: GoodsLocalDataSource,
    private val fakeApi: FakeAPI
) : GoodsStoreRepository {

    override suspend fun getGoods(): Flow<List<Good>> {
        CoroutineScope(coroutineContext).async {
            saveData()
        }.await()
        return localDataSource.getAllGoods()
    }

    override suspend fun getGoodsSortedBySeries(): Flow<List<Good>> {
        CoroutineScope(coroutineContext).async {
            saveData()
        }.await()
        return localDataSource.getAllGoodsSortedBySeries()
    }

    private suspend fun isDataSaved(): Boolean {
        val result = preferencesDataSource.isDataExist(key = PreferencesKeys.DATA_EXIST_KEY)
        return result.first() ?: false
    }

    private suspend fun saveData() {
        val isSaved = isDataSaved()
        if (isSaved){
            return
        }
        val data = fakeApi.getData()
        preferencesDataSource.setDataExist(PreferencesKeys.DATA_EXIST_KEY, true)
        localDataSource.insertGood(data)

    }
}