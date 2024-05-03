package com.appinventiv.cleanarchitecturecompose.presentation.screens.detailScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appinventiv.cleanarchitecturecompose.domain.models.Quote

@Composable
fun DetailQuote(data: Quote?) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)
        .padding(15.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(Color.White)
        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = data?.quote ?: "Dummy Quotes Text",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = Color.Black)
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = data?.author ?: "Abhishek Nigam",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
                fontWeight = FontWeight.W300,
                fontSize = 12.sp,
                color = Color.Black)
        }

    }
}

@Preview
@Composable
private fun DetailQuotePreview(){
    DetailQuote(null)
}