package com.appinventiv.cleanarchitecturecompose.presentation.screens.homeScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
fun QuoteItem(
    quote: Quote,
    color: Color = Color.White,
    textColor: Color = Color.Black,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = quote.quote ?: "Dummy Data from Source",
                modifier = Modifier.fillMaxWidth(),
                color = textColor,
                fontSize = 14.sp,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = quote.author ?: "Developer has their life too",
                modifier = Modifier.fillMaxWidth(),
                color = textColor,
                fontSize = 12.sp,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.W300,
            )

        }

    }

}

@Preview(showBackground = true)
@Composable
fun QuoteItemPreview(){
    QuoteItem(quote = Quote())
}