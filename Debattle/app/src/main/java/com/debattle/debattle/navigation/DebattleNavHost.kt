package com.debattle.debattle.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.debattle.home.homeRoute
import com.debattle.home.homeScreen
import com.debattle.login.navigation.loginRoute
import com.debattle.login.navigation.loginScreen
import com.debattle.post.navigation.PostRoute
import com.debattle.post.navigation.navigateToPost
import com.debattle.post.navigation.postScreen
import com.debattle.rank.navigation.RankRoute
import com.debattle.rank.navigation.rankScreen

@Composable
fun DebattleNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = RankRoute) {
        loginScreen()
        homeScreen {
            navHostController.navigateToPost()
        }
        postScreen()
        rankScreen()
    }
}