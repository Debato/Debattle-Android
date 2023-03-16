package com.debattle.domain

import com.debattle.data.HomeRepository
import javax.inject.Inject

class GetAllRankUseCase @Inject constructor(private val homeRepository: HomeRepository) {
    suspend operator fun invoke() = homeRepository.getAllRank()
}