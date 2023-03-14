package com.debattle.data

import com.debattle.network.retrofit.model.Article

interface HomeRepository {
    suspend fun getAllArticles(): List<Article>
}