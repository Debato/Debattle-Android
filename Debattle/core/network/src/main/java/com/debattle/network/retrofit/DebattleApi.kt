package com.debattle.network.retrofit

import com.debattle.network.retrofit.model.Article
import retrofit2.http.GET

interface DebattleApi {
    @GET("/article")
    suspend fun getAllArticles(): List<Article>
}