package com.debattle.network.retrofit.model

import kotlinx.serialization.Serializable

@Serializable
data class User(val userId: Int, val nickname: String, val thumbnail: String)
