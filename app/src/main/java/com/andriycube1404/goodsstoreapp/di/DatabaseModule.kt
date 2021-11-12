package com.andriycube1404.goodsstoreapp.di

import android.app.Application
import androidx.room.Room
import com.andriycube1404.goodsstoreapp.store.data.db.GoodDao
import com.andriycube1404.goodsstoreapp.store.data.db.GoodsStoreDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideGoodsStoreDatabase(
        app: Application
    ): GoodsStoreDatabase {
        return Room.databaseBuilder(
            app,
            GoodsStoreDatabase::class.java,
            GoodsStoreDatabase.DB_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideGoodDao(
        database: GoodsStoreDatabase
    ): GoodDao {
        return database.goodDao
    }
}