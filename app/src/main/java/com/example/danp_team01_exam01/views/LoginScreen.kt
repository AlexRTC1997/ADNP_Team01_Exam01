package com.example.danp_team01_exam01.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "LoginScreen")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Login")
        }
    }
}