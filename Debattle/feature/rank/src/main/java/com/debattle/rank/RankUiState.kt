package com.debattle.rank

import com.debattle.network.retrofit.model.Article

interface RankUiState {
    data class Success(val data: List<Article>): RankUiState
    data class Error(val message: String): RankUiState
    object Loading: RankUiState
}