package com.example.danp_team01_exam01.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.danp_team01_exam01.classes.Destination

@Composable
fun ReportCard(navController: NavHostController, reportId: Int) {
    Row(modifier = Modifier
        .fillMaxSize()
        .height(24.dp)
        .clickable { navController.navigate(Destination.Details.createRoute(reportId = reportId)) }) {
        Text(text = "Report # $reportId")
    }
}