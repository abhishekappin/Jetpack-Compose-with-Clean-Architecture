package com.appinventiv.cleanarchitecturecompose.data.remote

import com.appinventiv.cleanarchitecturecompose.domain.models.AllQuoteModel
import com.appinventiv.cleanarchitecturecompose.domain.models.Quote
import com.appinventiv.cleanarchitecturecompose.network.ALL_QUOTES
import com.appinventiv.cleanarchitecturecompose.network.RANDOM_QUOTE
import com.appinventiv.cleanarchitecturecompose.network.SINGLE_QUOTE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET(ALL_QUOTES)
    suspend fun getAllQuotes() : Response<AllQuoteModel>

    @GET(RANDOM_QUOTE)
    suspend fun getRandomQuote() : Response<Quote>

    @GET(SINGLE_QUOTE)
    suspend fun getSingleQuote(@Path("id") id: String) : Response<Quote>

}