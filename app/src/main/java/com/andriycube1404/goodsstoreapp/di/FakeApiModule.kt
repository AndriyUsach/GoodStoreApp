package com.andriycube1404.goodsstoreapp.di

import android.app.Application
import com.andriycube1404.goodsstoreapp.store.data.api.FakeAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FakeApiModule {

    @Provides
    @Singleton
    fun provideFakeApi(
        app: Application
    ): FakeAPI {
        return FakeAPI(app)
    }
}