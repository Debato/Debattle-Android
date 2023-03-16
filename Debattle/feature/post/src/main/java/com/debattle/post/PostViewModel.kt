package com.debattle.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debattle.domain.PostArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postArticleUseCase: PostArticleUseCase
): ViewModel() {
    fun postArticle(title: String, content: String, agreement: Boolean) {
        viewModelScope.launch {
            postArticleUseCase(title, content, agreement)
        }
    }
}