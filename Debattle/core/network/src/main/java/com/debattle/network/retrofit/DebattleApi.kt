package com.debattle.network.retrofit

import com.debattle.network.retrofit.model.Article
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface DebattleApi {
    @GET("/article")
    suspend fun getAllArticles(): List<Article>

    @POST("/user")
    suspend fun signUp(@Header("token") token: String)
}