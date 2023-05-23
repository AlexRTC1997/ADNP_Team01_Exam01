package com.example.danp_team01_exam01.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RegisterScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "RegisterScreen")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Register")
        }
    }
}