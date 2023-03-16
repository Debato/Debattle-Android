package com.debattle.data

import com.debattle.network.retrofit.DebattleApi
import com.debattle.network.retrofit.model.Article
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val debattleApi: DebattleApi):HomeRepository {
    override suspend fun getAllArticles(): List<Article> =
        debattleApi.getAllArticles()

    override suspend fun signUp(token: String) {
        debattleApi.signUp(token)
    }

    override suspend fun postArticles(title: String, content: String, agreement: Boolean) {
        debattleApi.postArticles(title, content, agreement)
    }

    override suspend fun updateLikes(id: Int) {
        debattleApi.updateLikes(id)
    }

    override suspend fun getAllRank(): List<Article> =
        debattleApi.getAllRank()

}