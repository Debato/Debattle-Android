package com.debattle.domain

import com.debattle.data.HomeRepository
import javax.inject.Inject

class UpdateLikesUseCase @Inject constructor(private val homeRepository: HomeRepository) {
    suspend operator fun invoke(id: Int) {
        homeRepository.updateLikes(id)
    }
}