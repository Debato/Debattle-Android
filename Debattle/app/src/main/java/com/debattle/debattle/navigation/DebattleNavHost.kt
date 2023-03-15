package com.debattle.debattle.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.debattle.home.homeRoute
import com.debattle.home.homeScreen
import com.debattle.post.navigation.navigateToPost
import com.debattle.post.navigation.postScreen

@Composable
fun DebattleNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = homeRoute) {
//        loginScreen()
        homeScreen {
            navHostController.navigateToPost()
        }
        postScreen()
    }
}