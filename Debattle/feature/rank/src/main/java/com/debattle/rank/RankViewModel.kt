package com.debattle.rank

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debattle.domain.GetAllRankUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankViewModel @Inject constructor(
    private val getAllRankUseCase: GetAllRankUseCase
): ViewModel() {
    fun getAllRank() {
        viewModelScope.launch {
            Log.d("rankTest", getAllRankUseCase().toString())
        }
    }
}