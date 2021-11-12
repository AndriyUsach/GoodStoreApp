package com.andriycube1404.goodsstoreapp.store.data.repositories

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface StorePreferencesDataSource {

    suspend fun isDataExist(key: Preferences.Key<Boolean>): Flow<Boolean?>
    suspend fun setDataExist(key: Preferences.Key<Boolean>, value: Boolean)
}