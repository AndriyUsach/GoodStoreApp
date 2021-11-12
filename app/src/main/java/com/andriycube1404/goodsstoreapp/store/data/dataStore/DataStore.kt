package com.andriycube1404.goodsstoreapp.store.data.dataStore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

private const val DATA_STORE_SETTINGS = "com.andriycube1404.goodsstoreapp.dataStore_settings"

val Context.dataStore by preferencesDataStore(
    name = DATA_STORE_SETTINGS
)