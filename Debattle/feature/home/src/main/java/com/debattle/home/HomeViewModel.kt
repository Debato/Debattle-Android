package com.debattle.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debattle.domain.GetAllArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getAllArticleUseCase: GetAllArticleUseCase) :
    ViewModel() {

    init {
        getAllArticles()
    }

    fun getAllArticles() {
        viewModelScope.launch {
            getAllArticleUseCase()
            Log.d("getall", getAllArticleUseCase().toString())
        }
    }
}