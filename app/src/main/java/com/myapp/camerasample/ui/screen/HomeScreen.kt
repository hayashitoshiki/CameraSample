package com.myapp.camerasample.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {
    var isCamera by remember { mutableStateOf(false) }

    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { isCamera = true }) {
                Text(text = "カメラ起動")
            }
        }
        if (isCamera) {
            CameraEvent(
                onClickPositiveAction = { isCamera = false },
                onClickNegativeAction = { isCamera = false }
            )
        }
    }
}