package com.example.danp_team01_exam01.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.danp_team01_exam01.classes.Destination
import androidx.compose.foundation.lazy.items
import com.example.danp_team01_exam01.composables.BackgroundCircle
import com.example.danp_team01_exam01.composables.ReportCard


@Composable
fun HomeScreen(navController: NavHostController) {
    val reportsList = MutableList(10) { it }

    BackgroundCircle()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "HomeScreen")
        Button(onClick = { navController.navigate(Destination.Login.route) }) {
            Text(text = "Logout")
        }

        LazyColumn(
            contentPadding = PaddingValues(all = 4.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(reportsList) {
                ReportCard(navController = navController, reportId = it)
            }
        }

    }
}