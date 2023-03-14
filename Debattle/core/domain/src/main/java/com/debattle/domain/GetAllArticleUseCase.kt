package com.debattle.domain

import com.debattle.data.HomeRepository
import javax.inject.Inject

class GetAllArticleUseCase @Inject constructor(private val homeRepository: HomeRepository) {
    suspend operator fun invoke() = homeRepository.getAllArticles()
}