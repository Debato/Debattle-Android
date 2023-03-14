package com.debattle.di

import com.debattle.data.HomeRepository
import com.debattle.data.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    fun bindsHomePagingRepository(
        homePagingRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository
}