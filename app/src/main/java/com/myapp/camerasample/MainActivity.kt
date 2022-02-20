package com.myapp.camerasample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.myapp.camerasample.ui.AppNavHost
import com.myapp.camerasample.ui.component.BottomBar
import com.myapp.camerasample.ui.screen.HomeScreen
import com.myapp.camerasample.ui.theme.CameraSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CameraSampleTheme {
                Scaffold(
                    bottomBar = { BottomBar(navController) },
                    backgroundColor = Color(0xfff5f5f5)
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        AppNavHost(navController = navController)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CameraSampleTheme {
        HomeScreen()
    }
}