package com.example.danp_team01_exam01.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.danp_team01_exam01.classes.Destination
import com.example.danp_team01_exam01.composables.BackgroundCircle

@Composable
fun LoginScreen(navController: NavHostController) {
    BackgroundCircle()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "LoginScreen")
        // [NAV05]
        Button(onClick = { navController.navigate(Destination.Home.route) }) {
            Text(text = "Login")
        }
        Button(onClick = { navController.navigate(Destination.Register.route) }) {
            Text(text = "Register")
        }
    }
}