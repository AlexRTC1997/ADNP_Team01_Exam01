package com.example.danp_team01_exam01.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.danp_team01_exam01.R
import com.example.danp_team01_exam01.classes.Destination
import com.example.danp_team01_exam01.composables.BackgroundCircle
import com.example.danp_team01_exam01.ui.theme.AppName
import com.example.danp_team01_exam01.ui.theme.SecondaryColor

@Composable
fun LoginScreen(navController: NavHostController) {
    BackgroundCircle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp, 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = AppName,
                color = SecondaryColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.main_image),
            contentDescription = "Main image",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(128.dp))

        // [NAV05]
        Button(onClick = { navController.navigate(Destination.Home.route) }) {
            Text(text = "Login")
        }
        Button(onClick = { navController.navigate(Destination.Register.route) }) {
            Text(text = "Register")
        }
    }
}