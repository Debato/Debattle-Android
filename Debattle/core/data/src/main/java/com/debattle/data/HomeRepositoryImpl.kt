package com.debattle.data

import com.debattle.network.retrofit.DebattleApi
import com.debattle.network.retrofit.model.Article
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val debattleApi: DebattleApi):HomeRepository {
    override suspend fun getAllArticles(): List<Article> =
        debattleApi.getAllArticles()
}