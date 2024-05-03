package com.appinventiv.cleanarchitecturecompose.data.repositoryImpl

import com.appinventiv.cleanarchitecturecompose.data.remote.ApiInterface
import com.appinventiv.cleanarchitecturecompose.domain.models.AllQuoteModel
import com.appinventiv.cleanarchitecturecompose.domain.models.Quote
import com.appinventiv.cleanarchitecturecompose.domain.repository.QuoteRepository
import retrofit2.Response
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface
) : QuoteRepository {
    override suspend fun getAllQuotes(): Response<AllQuoteModel> = apiInterface.getAllQuotes()

    override suspend fun getRandomQuote(): Response<Quote> = apiInterface.getRandomQuote()

    override suspend fun getSingleQuote(id: String): Response<Quote> = apiInterface.getSingleQuote(id)
}