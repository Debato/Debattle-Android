package com.debattle.data

import com.debattle.network.retrofit.model.Article

interface HomeRepository {
    suspend fun getAllArticles(): List<Article>

    suspend fun signUp(token: String)

    suspend fun postArticles(title: String, content: String, agreement: Boolean)
}