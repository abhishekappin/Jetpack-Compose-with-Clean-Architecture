package com.appinventiv.cleanarchitecturecompose.domain.useCases

import com.appinventiv.cleanarchitecturecompose.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSingleQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {
    operator fun invoke(id: String) = flow {
        quoteRepository.getSingleQuote(id).let {
            if (it.isSuccessful)
                emit(it.body())
        }
    }
}