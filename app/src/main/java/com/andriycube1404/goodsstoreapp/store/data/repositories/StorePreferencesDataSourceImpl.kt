package com.andriycube1404.goodsstoreapp.store.data.repositories

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class StorePreferencesDataSourceImpl(
    private val dataStore: DataStore<Preferences>
) : StorePreferencesDataSource {
    override suspend fun isDataExist(key: Preferences.Key<Boolean>): Flow<Boolean?> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException)
                    emit(emptyPreferences())
                else
                    throw exception
            }.map { preferences ->
                val isDataSaved = preferences[key]
                isDataSaved ?: false
            }
    }

    override suspend fun setDataExist(key: Preferences.Key<Boolean>, value: Boolean) {
        dataStore.edit { preferences ->
            preferences[key] = value
        }
    }
}