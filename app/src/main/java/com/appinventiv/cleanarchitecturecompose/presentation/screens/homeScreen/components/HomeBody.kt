package com.appinventiv.cleanarchitecturecompose.presentation.screens.homeScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appinventiv.cleanarchitecturecompose.domain.models.HomeQuoteModel

@Composable
fun HomeBody(homeQuoteModel: HomeQuoteModel, onClick: (id: String)->Unit){
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)){
        homeQuoteModel.randomQuote?.let {
            item{
                HeadingTitle(title = "Random Quote")
                RandomQuoteItem(it)
            }
        }
        item {
            HeadingTitle(title = "Quotes")
        }
        items(homeQuoteModel.allQuoteList ?: emptyList()){
            QuoteItem(
                quote = it,
                modifier = Modifier.clickable { onClick(it.id.toString()) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeBodyPreview(){
    HomeBody(HomeQuoteModel()){}
}