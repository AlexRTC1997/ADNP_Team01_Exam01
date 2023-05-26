package com.example.danp_team01_exam01.classes

// [NAV02] Class Destination with App routes
sealed class Destination(val title: String, val route: String) {
    object Home : Destination("Home","home")
    object Login : Destination("Login","login")
    object Register : Destination("Register","register")
    object Details : Destination("Details","details")
    object Edit : Destination("Edit", "edit")

    fun routeWithArgs (vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}