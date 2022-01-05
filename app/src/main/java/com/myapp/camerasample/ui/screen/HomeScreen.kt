package com.myapp.camerasample.ui.screen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {
    Surface(color = MaterialTheme.colors.background) {
        Greeting("Android")
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}