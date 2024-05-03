package com.appinventiv.cleanarchitecturecompose.presentation.screens.homeScreen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.appinventiv.cleanarchitecturecompose.domain.models.Quote

@Composable
fun RandomQuoteItem(quote : Quote){
    QuoteItem(
        quote = quote,
        color = Color.Red,
        textColor = Color.White
    )
}

@Preview
@Composable
fun RandomQuoteItemPreview(){
    RandomQuoteItem(Quote())
}