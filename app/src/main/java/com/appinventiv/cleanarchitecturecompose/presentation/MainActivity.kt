package com.appinventiv.cleanarchitecturecompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.appinventiv.cleanarchitecturecompose.presentation.navigation.AppNavController
import com.appinventiv.cleanarchitecturecompose.presentation.screens.detailScreen.DetailScreen
import com.appinventiv.cleanarchitecturecompose.presentation.screens.homeScreen.HomeScreen
import com.appinventiv.cleanarchitecturecompose.presentation.ui.theme.CleanArchitectureComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitectureComposeTheme {
//                HomeScreen()
//                DetailScreen()
                AppNavController()
            }

        }
    }
}