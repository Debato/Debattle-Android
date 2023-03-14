package com.debattle.domain

import com.debattle.data.HomeRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val homeRepository: HomeRepository) {
    suspend operator fun invoke(token: String) {
        homeRepository.signUp(token)
    }
}