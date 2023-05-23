package com.example.danp_team01_exam01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.danp_team01_exam01.composables.NavigationAppHost
import com.example.danp_team01_exam01.ui.theme.DANP_Team01_Exam01Theme

/*
    [NAVIGATION NOTES]
    1. [NAV01] Add Android Navigation Dependency in build.gradle(app)
    2. [NAV02] Create class Destination
    3. [NAV03] Create NavigationAppHost composable
    4. [NAV04] Add NavigationAppHost in MainActivity
    5. [NAV05] Associate Navigation action to buttons
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DANP_Team01_Exam01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController)
                }
            }
        }
    }
}
