package com.example.danp_team01_exam01.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.danp_team01_exam01.composables.NavigationAppHost
import com.example.danp_team01_exam01.ui.theme.DANP_Team01_Exam01Theme
import com.example.danp_team01_exam01.ui.theme.TertiaryColor
import com.example.danp_team01_exam01.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DANP_Team01_Exam01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = TertiaryColor,
                ) {
                    val navController = rememberNavController()
                    val viewModel: MainViewModel = hiltViewModel()
                    NavigationAppHost(viewModel = viewModel, navController = navController)
                }
            }
        }
    }
}
