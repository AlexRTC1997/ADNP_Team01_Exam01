package com.example.danp_team01_exam01.classes

// [NAV02] Class Destination with App routes
sealed class Destination(val route: String) {
    object Home : Destination("home")
    object Login : Destination("login")
    object Register : Destination("register")
    object Details : Destination("details/{reportId}") {
        fun createRoute(reportId: Int) = "details/$reportId"
    }

    object Edit : Destination("edit/{reportId}") {
        fun createRoute(reportId: Int) = "edit/$reportId"
    }
}