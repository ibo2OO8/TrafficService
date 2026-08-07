package com.ibrohimapk3.trafficservice.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ibrohimapk3.trafficservice.screen.AddAutomobileScreen
import com.ibrohimapk3.trafficservice.screen.ServiceScreen

@Composable
fun MyNavController(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "service"
    ) {
        composable("service") {
            ServiceScreen(
                navigate = {
                    navController.navigate("addAutomobile")
                },
                modifier = modifier
            )
        }
        composable("addAutomobile") {
            AddAutomobileScreen(onBack = {
                navController.popBackStack()
            }, modifier = modifier)

        }
    }
}