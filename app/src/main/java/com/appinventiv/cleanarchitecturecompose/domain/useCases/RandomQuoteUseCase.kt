package com.appinventiv.cleanarchitecturecompose.domain.useCases

import com.appinventiv.cleanarchitecturecompose.data.remote.ApiInterface
import com.appinventiv.cleanarchitecturecompose.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RandomQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
){
    operator fun invoke() = flow {
        quoteRepository.getRandomQuote().let {
            if (it.isSuccessful){
                emit(it.body())
            }
        }
    }
}