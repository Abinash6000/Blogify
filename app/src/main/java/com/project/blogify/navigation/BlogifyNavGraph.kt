package com.project.blogify.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun BlogifyNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.Home.route,
        modifier = modifier
    ) {
        composable(route = NavigationScreen.Home.route) {

        }

        composable(route = NavigationScreen.Detail.route) { backStackEntry ->
            val webUrl = backStackEntry.arguments?.getString("url")
        }
    }
}