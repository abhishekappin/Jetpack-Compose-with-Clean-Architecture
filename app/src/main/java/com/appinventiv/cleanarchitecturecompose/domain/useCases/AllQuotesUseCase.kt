package com.appinventiv.cleanarchitecturecompose.domain.useCases

import com.appinventiv.cleanarchitecturecompose.domain.models.AllQuoteModel
import com.appinventiv.cleanarchitecturecompose.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AllQuotesUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {

    operator fun invoke() =  flow {
        quoteRepository.getAllQuotes().let {
            if (it.isSuccessful){
                emit(it.body()?.quotes)
            }
        }
    }
}