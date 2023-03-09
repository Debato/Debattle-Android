package com.debattle.debattle.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.debattle.login.navigation.loginRoute
import com.debattle.login.navigation.loginScreen

@Composable
fun DebattleNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = loginRoute) {
        loginScreen()
    }
}