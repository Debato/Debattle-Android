package com.debattle.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.debattle.login.LoginScreen

const val loginRoute = "login_route"

fun NavGraphBuilder.loginScreen() {
    composable(route = loginRoute) {
//        LoginScreen()
    }
}
