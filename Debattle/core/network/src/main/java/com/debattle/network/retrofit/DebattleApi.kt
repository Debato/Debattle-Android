package com.debattle.network.retrofit

import com.debattle.network.retrofit.model.Article
import retrofit2.http.*

interface DebattleApi {
    @GET("/article")
    suspend fun getAllArticles(): List<Article>

    @POST("/user")
    suspend fun signUp(@Header("token") token: String)

    @FormUrlEncoded
    @POST("/article")
    suspend fun postArticles(@Field("title") title: String, @Field("content") content: String, @Field("agreement") agreement: Boolean)

    @POST("/article/like/{id}")
    suspend fun updateLikes(@Path("articleId") id: Int)


}