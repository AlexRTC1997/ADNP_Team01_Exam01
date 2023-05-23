package com.example.danp_team01_exam01.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun DetailsScreen(navController: NavHostController, reportId: Int) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Details of Report #$reportId")
        Button(onClick = { navController.navigate("home") }) {
            Text(text = "Back")
        }
        // Edit and Delete Button
    }
}