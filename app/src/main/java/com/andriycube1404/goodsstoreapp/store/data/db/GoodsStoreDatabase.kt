package com.andriycube1404.goodsstoreapp.store.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.andriycube1404.goodsstoreapp.store.data.entities.GoodEntity

@Database(
    version = GoodsStoreDatabase.DB_VERSION,
    entities = [GoodEntity::class]
)
abstract class GoodsStoreDatabase : RoomDatabase() {

    abstract val goodDao: GoodDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "goods_store_db"
    }
}