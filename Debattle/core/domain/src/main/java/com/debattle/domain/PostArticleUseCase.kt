package com.debattle.domain

import com.debattle.data.HomeRepository
import javax.inject.Inject

class PostArticleUseCase @Inject constructor(private val homeRepository: HomeRepository) {
    suspend operator fun invoke(title: String, content: String, agreement: Boolean) {
        homeRepository.postArticles(title, content, agreement)
    }
}