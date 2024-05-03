package com.appinventiv.cleanarchitecturecompose.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.appinventiv.cleanarchitecturecompose.presentation.screens.detailScreen.DetailScreen
import com.appinventiv.cleanarchitecturecompose.presentation.screens.homeScreen.HomeScreen

@Composable
fun AppNavController(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenName.HOME_SCREEN){
        composable(route = ScreenName.HOME_SCREEN){
            HomeScreen{id ->
                navController.navigate(ScreenName.DETAIL_SCREEN +"/$id")
            }
        }
        composable(route = ScreenName.DETAIL_SCREEN+"/{id}", arguments = listOf(
            navArgument(name = "id"){
                type = NavType.StringType
            }
        )){
            Log.d("DEV_NO_LIMIT", "${it.arguments?.getString("id")}")
            DetailScreen{
                navController.popBackStack()
            }
        }
    }
}