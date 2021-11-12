package com.andriycube1404.goodsstoreapp.di

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.andriycube1404.goodsstoreapp.store.data.api.FakeAPI
import com.andriycube1404.goodsstoreapp.store.data.dataStore.dataStore
import com.andriycube1404.goodsstoreapp.store.data.db.GoodDao
import com.andriycube1404.goodsstoreapp.store.data.repositories.*
import com.andriycube1404.goodsstoreapp.store.domain.repository.GoodsStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideDataStore(
        app: Application
    ): DataStore<Preferences> {
        return app.dataStore
    }

    @Provides
    fun providePreferencesDataSource(
        dataStore: DataStore<Preferences>
    ): StorePreferencesDataSource {
        return StorePreferencesDataSourceImpl(dataStore)
    }

    @Provides
    fun provideGoodsLocalDataSource(
        goodDao: GoodDao,
        app: Application
    ): GoodsLocalDataSource {
        return GoodsLocalDataSourceImpl(goodDao, app)
    }

    @Provides
    fun provideGoodsStoreRepository(
        localDataSource: GoodsLocalDataSource,
        preferencesDataSource: StorePreferencesDataSource,
        fakeAPI: FakeAPI
    ): GoodsStoreRepository {
        return GoodsStoreRepositoryImpl(
            localDataSource = localDataSource,
            preferencesDataSource = preferencesDataSource,
            fakeApi = fakeAPI
        )
    }
}