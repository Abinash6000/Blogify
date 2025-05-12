package com.project.blogify.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.project.blogify.navigation.BlogifyNavHost

@Composable
fun BlogifyApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    BlogifyNavHost(navController = navController, modifier = modifier)
}