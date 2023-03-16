package com.debattle.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debattle.domain.GetAllArticleUseCase
import com.debattle.domain.SignUpUseCase
import com.debattle.domain.UpdateLikesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllArticleUseCase: GetAllArticleUseCase,
    private val updateLikesUseCase: UpdateLikesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun getAllArticles() {
        viewModelScope.launch {
            try {
                _uiState.value = HomeUiState.Success(getAllArticleUseCase())
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(e.localizedMessage ?: "알 수 없는 에러")
            }

            Log.d("getall", getAllArticleUseCase().toString())
        }
    }

    fun updateLikes(id: Int) {
        viewModelScope.launch {
            updateLikesUseCase(id)
        }
    }
}