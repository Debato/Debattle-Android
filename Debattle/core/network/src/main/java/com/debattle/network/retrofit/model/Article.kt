package com.debattle.network.retrofit.model

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val articleId: Int,
    val content: String,
    val title: String,
    val like: Int,
    val agreement: Boolean
)
