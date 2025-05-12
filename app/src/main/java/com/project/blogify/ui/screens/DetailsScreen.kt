package com.project.blogify.ui.screens

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    url: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Read Post",
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.SemiBold)
                    )
                },
                navigationIcon = {
                    BackIcon(onBackClick)
                }
            )
        }
    ) { contentPadding ->
        AndroidView( // It allows you to embed classic Android Views (like WebView, MapView, etc.) inside Jetpack Compose
            factory = {
                WebView(it).apply { // 'it' is the Context passed by Compose, we're creating a WebView here using that context.
                    layoutParams = ViewGroup.LayoutParams( // Sets the width and height of the WebView to match the parent
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient() //  This tells the WebView to handle URL loading inside the app
                    loadUrl(url) // Loads the URL we passed in
                }
            },
            update = { // Reloads the URL in case the value of mUrl changed
                it.loadUrl(url) // Reloads the URL in case the value of url changed
            },
            modifier = modifier.padding(contentPadding)
        )
    }
}

@Composable
fun BackIcon(
    onBackClick: () -> Unit
) {
    IconButton(
        onClick = { onBackClick() }
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
            contentDescription = "Back"
        )
    }
}
