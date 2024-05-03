package com.appinventiv.cleanarchitecturecompose.presentation.screens.detailScreen

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
import com.appinventiv.cleanarchitecturecompose.presentation.screens.detailScreen.components.DetailQuote

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel = hiltViewModel(),
    onBackPress: ()->Unit
) {
    val state = detailViewModel.singleQuoteData.collectAsState().value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ToolbarComponent(
                showBackButton = true,
                title = "Detail",
                onBackPress = onBackPress,
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
            ) {
            when(state) {
                is NetworkState.LOADING -> {
                    AppProgressBar()
                }
                is NetworkState.SUCCESS -> {
                    DetailQuote(state.data)
                }
                is NetworkState.ERROR -> {

                }
            }
//            DetailQuote()
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DetailScreenPreview() {
    DetailScreen{}
}