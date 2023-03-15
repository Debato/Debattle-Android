package com.debattle.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val homeRoute = "home_route"

fun NavController.navigateToHome() {

}

fun NavGraphBuilder.homeScreen(navigateToPost: () -> Unit) {
    composable(route = homeRoute) {
        HomeScreen(navigateToPost)
    }
}
