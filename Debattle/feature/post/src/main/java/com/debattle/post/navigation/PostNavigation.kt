package com.debattle.post.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.debattle.post.PostScreen

const val PostRoute = "post_route"

fun NavGraphBuilder.postScreen() {
    composable(route = PostRoute) {
        PostScreen()
    }
}

fun NavController.navigateToPost() {
    this.navigate(PostRoute)
}