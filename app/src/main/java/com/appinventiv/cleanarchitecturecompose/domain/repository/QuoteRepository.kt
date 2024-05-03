package com.appinventiv.cleanarchitecturecompose.domain.repository

import com.appinventiv.cleanarchitecturecompose.domain.models.AllQuoteModel
import com.appinventiv.cleanarchitecturecompose.domain.models.Quote
import retrofit2.Response

interface QuoteRepository {

    suspend fun getAllQuotes() : Response<AllQuoteModel>

    suspend fun getRandomQuote() : Response<Quote>

    suspend fun getSingleQuote(id: String) : Response<Quote>
}