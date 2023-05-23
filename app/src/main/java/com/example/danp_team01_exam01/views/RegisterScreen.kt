package com.example.danp_team01_exam01.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.danp_team01_exam01.classes.Destination

@Composable
fun RegisterScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "RegisterScreen")
        Button(onClick = { navController.navigate(Destination.Login.route) }) {
            Text(text = "Register")
        }
    }
}