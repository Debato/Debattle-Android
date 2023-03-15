package com.debattle.home

import com.debattle.network.retrofit.model.Article

sealed interface HomeUiState {
    object Loading: HomeUiState
    data class Error(val message: String): HomeUiState
    data class Success(val data: List<Article>): HomeUiState
}
