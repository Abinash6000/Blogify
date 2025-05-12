package com.project.blogify.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.project.blogify.ui.screens.DetailsScreen
import com.project.blogify.ui.screens.HomeScreen


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
            HomeScreen(
                navigateToDetail = { url ->
                    navController.navigate(NavigationScreen.Detail.passWebUrl(url))
                }
            )
        }

        composable(route = NavigationScreen.Detail.route) { backStackEntry ->
            val webUrl = backStackEntry.arguments?.getString("url")
            DetailsScreen(
                url = webUrl ?: "",
                modifier = modifier
            )
        }
    }
}