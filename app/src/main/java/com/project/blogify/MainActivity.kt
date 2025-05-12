package com.project.blogify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.blogify.ui.screens.BlogifyApp
import com.project.blogify.ui.theme.BlogifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlogifyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BlogifyApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}