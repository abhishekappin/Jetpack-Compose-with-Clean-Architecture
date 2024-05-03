package com.appinventiv.cleanarchitecturecompose.domain.models

data class HomeQuoteModel(
    val randomQuote : Quote? = null,
    val allQuoteList : List<Quote>? = null
)
