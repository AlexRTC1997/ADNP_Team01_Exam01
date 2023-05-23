package com.example.danp_team01_exam01.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.danp_team01_exam01.classes.Destination
import com.example.danp_team01_exam01.views.DetailsScreen
import com.example.danp_team01_exam01.views.HomeScreen
import com.example.danp_team01_exam01.views.LoginScreen
import com.example.danp_team01_exam01.views.RegisterScreen

// [NAV03] NavigationAppHost Composable to associate route and screen
@Composable
fun NavigationAppHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable(Destination.Login.route) { LoginScreen(navController = navController) }
        composable(Destination.Register.route) { RegisterScreen(navController = navController) }
        composable(Destination.Home.route) { HomeScreen(navController = navController) }
        composable(Destination.Details.route) { navBackStackEntry ->
            val reportId = navBackStackEntry.arguments?.getString("reportId")

            if (reportId != null) {
                DetailsScreen(navController, reportId = reportId.toInt())
            }
        }
    }
}