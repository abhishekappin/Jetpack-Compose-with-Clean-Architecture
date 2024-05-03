package com.appinventiv.cleanarchitecturecompose.presentation.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.appinventiv.cleanarchitecturecompose.network.NetworkState
import com.appinventiv.cleanarchitecturecompose.presentation.components.AppProgressBar
import com.appinventiv.cleanarchitecturecompose.presentation.components.ToolbarComponent
import com.appinventiv.cleanarchitecturecompose.presentation.screens.homeScreen.components.HomeBody
import dagger.hilt.android.lifecycle.HiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onClick: (id: String)->Unit
){
    val state = homeViewModel.quotedData.collectAsState().value
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        topBar = {
            ToolbarComponent(title = "Home")
        }
    ) {paddingValues ->
        Box(modifier = Modifier.padding(paddingValues),
            contentAlignment = Alignment.Center) {
            when (state){
                is NetworkState.LOADING -> {
                    AppProgressBar()
                }
                is NetworkState.SUCCESS -> {
                    HomeBody (state.data, onClick = onClick)
                }
                is NetworkState.ERROR -> {

                }
                else -> Unit
            }
//            HomeBody(onClick)
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen{}
}