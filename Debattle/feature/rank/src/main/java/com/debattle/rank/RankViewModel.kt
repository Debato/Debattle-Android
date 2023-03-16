package com.debattle.rank

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debattle.domain.GetAllRankUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankViewModel @Inject constructor(
    private val getAllRankUseCase: GetAllRankUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<RankUiState>(RankUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun getAllRank() {
        viewModelScope.launch {
            try {
                _uiState.value = RankUiState.Success(getAllRankUseCase())
            } catch (e: Exception) {
                _uiState.value = RankUiState.Error(e.localizedMessage ?: "알 수 없는 에러")
            }
        }
    }
}