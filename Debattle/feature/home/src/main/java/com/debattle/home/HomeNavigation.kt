package com.debattle.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val homeRoute = "home_route"

fun NavGraphBuilder.homeScreen() {
    composable(route = homeRoute) {
        HomeScreen()
    }
}
