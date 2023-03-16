package com.debattle.rank.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.debattle.rank.RankScreen


const val RankRoute = "rank_route"

fun NavGraphBuilder.rankScreen() {
    composable(route = RankRoute) {
        RankScreen()
    }
}

fun NavController.navigateToRank() {
    this.navigate(RankRoute)
}