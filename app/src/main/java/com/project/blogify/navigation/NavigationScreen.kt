package com.project.blogify.navigation

sealed class NavigationScreen(val route: String) {
    object Home : NavigationScreen("home")
    object Detail : NavigationScreen("detail/{url}") {
        fun passWebUrl(url: String) = "detail/$url"
    }
}