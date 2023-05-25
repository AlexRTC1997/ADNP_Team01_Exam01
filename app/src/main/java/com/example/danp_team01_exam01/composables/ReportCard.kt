package com.example.danp_team01_exam01.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.danp_team01_exam01.R
import com.example.danp_team01_exam01.classes.Destination
import com.example.danp_team01_exam01.model.Report
import com.example.danp_team01_exam01.ui.theme.BlackColor

@Composable
fun ReportCard(navController: NavHostController, report: Report) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color(245, 245, 245))
            .padding(12.dp, 8.dp)
            .fillMaxWidth()
            .clickable { navController.navigate(Destination.Details.createRoute(reportId = report.id)) },
        verticalAlignment = Alignment.CenterVertically
//            .shadow(1.dp),

    ) {
        Image(
            painter = painterResource(id = R.drawable.trash),
            contentDescription = "Trash",
            modifier = Modifier.size(50.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = report.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = report.place, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.fillMaxHeight()) {
            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "Go Details",
                modifier = Modifier.size(24.dp),
                tint = BlackColor
            )
        }
    }
}