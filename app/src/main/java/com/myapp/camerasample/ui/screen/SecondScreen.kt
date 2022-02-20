package com.myapp.camerasample.ui.screen

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp


/**
 * 外部カメラアプリ起動
 *
 */
@Composable
fun SecondScreen() {
    var isCamera by remember { mutableStateOf(false) }
    val result = remember { mutableStateOf<Bitmap?>(null) }
    val takePictureLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) {
        result.value = it
        isCamera = false
    }

    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "-- 外部カメラ --")
            Button(
                onClick = { isCamera = true },
                modifier = Modifier.padding(top= 8.dp)
            ) {
                Text(text = "カメラ起動")
            }
            result.value?.let { image ->
                Image(image.asImageBitmap(), null, modifier = Modifier.fillMaxWidth())
            }
        }

        // 外部カメラ起動
        if (isCamera) {
            CameraPermissionHandler {
                if (it) {
                    takePictureLauncher.launch()
                }
            }
        }
    }
}