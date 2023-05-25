package com.example.danp_team01_exam01.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
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
import com.example.danp_team01_exam01.composables.BackgroundCircle
import com.example.danp_team01_exam01.ui.theme.PrimaryColor
import com.example.danp_team01_exam01.ui.theme.SecondaryColor

@Composable
fun DetailsScreen(navController: NavHostController, reportId: Int) {
    BackgroundCircle()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(24.dp, 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 20.dp)
                .fillMaxWidth(),
        ) {
            Text(
                fontSize = 24.sp,
                color = SecondaryColor,
                text = "Welcome @User",
                modifier = Modifier.weight(1f)
            )

            Icon(
                Icons.Default.ExitToApp,
                contentDescription = "Logout",
                tint = SecondaryColor,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.navigate(Destination.Login.route) }
            )
        }

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .fillMaxSize()
                .background(SecondaryColor)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Pollution Report",
                color = PrimaryColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column (
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color(245, 245, 245))
                    .padding(24.dp)
                    .fillMaxSize()
                    .clickable { navController.navigate(Destination.Details.createRoute(reportId = reportId)) },
                horizontalAlignment = Alignment.CenterHorizontally
//            .shadow(1.dp),

            ) {
                Image(
                    painter = painterResource(id = R.drawable.trash),
                    contentDescription = "Trash",
                    modifier = Modifier.size(100.dp)
                )
                
                Spacer(modifier = Modifier.height(32.dp))

                Text(text = "Title of the REPORT", fontSize = 18.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(18.dp))

                Column(horizontalAlignment = Alignment.Start) {
                    Text(text = "Hunter")

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(text = "Lorem ipsum bla bla bla... Lorem ipsum bla bla bla... Lorem ipsum bla bla bla...")
                }
            }
        }


//    Column(modifier = Modifier.fillMaxSize()) {
//        Text(text = "Details of Report #$reportId")
//        Button(onClick = { navController.navigate("home") }) {
//            Text(text = "Back")
//        }
//        // Edit and Delete Button
//    }
    }
}