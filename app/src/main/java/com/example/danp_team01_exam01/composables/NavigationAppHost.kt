package com.example.danp_team01_exam01.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.danp_team01_exam01.classes.Destination
import com.example.danp_team01_exam01.viewModel.MainViewModel
import com.example.danp_team01_exam01.views.DetailsScreen
import com.example.danp_team01_exam01.views.HomeScreen
import com.example.danp_team01_exam01.views.LoginScreen
import com.example.danp_team01_exam01.views.RegisterScreen

// [NAV03] NavigationAppHost Composable to associate route and screen
@Composable
fun NavigationAppHost(
    viewModel: MainViewModel,
    navController: NavHostController) {

    NavHost(navController = navController, startDestination = Destination.Login.route) {
        composable(route = Destination.Login.route) {
            LoginScreen(viewModel = viewModel, navController = navController)
        }

        composable(route = Destination.Register.route) {
            RegisterScreen(viewModel = viewModel, navController = navController)
        }

        composable( route = Destination.Home.route + "/{userEmail}",
            arguments = listOf(
                navArgument("userEmail") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        )  {
            val userEmail = it.arguments?.getString("userEmail")
            HomeScreen(viewModel = viewModel, navController = navController, userEmail = userEmail)
        }

        composable( route = Destination.Details.route + "/{reportId}",
            arguments = listOf(
                navArgument("reportId") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ) {
            val reportId = it.arguments?.getString("reportId")
            DetailsScreen(viewModel = viewModel, navController = navController, reportId = reportId)
        }

        composable( route = Destination.Edit.route + "/{reportId}",
            arguments = listOf(
                navArgument("reportId") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val reportId = it.arguments?.getString("reportId")
            EditReportForm(viewModel = viewModel, navController = navController, reportId = reportId)
        }
    }
}