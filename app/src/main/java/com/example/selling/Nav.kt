package com.example.selling

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_screen"){
        composable(route = "home_screen"){
            HomeScreen(navController = navController)
        }
        composable(
            route = "details_screen/{product}",
            arguments = listOf(navArgument("product") { defaultValue = "" })
        ){ navBackStack ->
            DetailsScreen(navController = navController)
        }

    }
}
