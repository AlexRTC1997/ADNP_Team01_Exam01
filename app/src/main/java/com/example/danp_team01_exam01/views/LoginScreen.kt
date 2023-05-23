@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.danp_team01_exam01.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.danp_team01_exam01.R
import com.example.danp_team01_exam01.classes.Destination
import com.example.danp_team01_exam01.composables.BackgroundCircle
import com.example.danp_team01_exam01.ui.theme.AppName
import com.example.danp_team01_exam01.ui.theme.BlackColor
import com.example.danp_team01_exam01.ui.theme.PrimaryColor
import com.example.danp_team01_exam01.ui.theme.SecondaryColor

@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    BackgroundCircle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp, 48.dp),
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

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Main image",
            modifier = Modifier.size(250.dp)
        )

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .background(SecondaryColor)
                .padding(28.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(text = "Login", fontSize = 22.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = { Text(text = "Email: ") },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { email = it },
                singleLine = true,
                value = email
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = { Text(text = "Password: ") },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { password = it },
                singleLine = true,
                value = password
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Forgot your password?", color = PrimaryColor, fontSize = 14.sp)

            Spacer(modifier = Modifier.height(24.dp))

            // [NAV05]
            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = SecondaryColor,
                    containerColor = PrimaryColor
                ),
                elevation = ButtonDefaults.buttonElevation(5.dp),
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(Destination.Home.route) }
            ) {
                Text(text = "Login", color = SecondaryColor, fontSize = 16.sp)
            }

            Row {
                Text(text = "Are you no registered?", color = BlackColor, fontSize = 14.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    modifier = Modifier.clickable { navController.navigate(Destination.Register.route) },
                    text = "Register here",
                    color = PrimaryColor,
                    fontSize = 14.sp
                )
            }
        }

    }
}