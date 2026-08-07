package com.ibrohimapk3.trafficservice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ibrohimapk3.trafficservice.navigation.MyNavController
import com.ibrohimapk3.trafficservice.ui.theme.TrafficServiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                scrim = android.graphics.Color.WHITE, darkScrim = android.graphics.Color.WHITE
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            TrafficServiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyNavController(
                        modifier = Modifier
                            .padding(top = innerPadding.calculateTopPadding())
                            .background(Color.White)
                    )
                }
            }
        }
    }
}
