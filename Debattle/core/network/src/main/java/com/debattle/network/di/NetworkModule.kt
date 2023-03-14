package com.debattle.network.di

import com.debattle.network.retrofit.DebattleApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit(): DebattleApi {
        return Retrofit.Builder()
            .baseUrl("http://10.82.20.102:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DebattleApi::class.java)
    }

}