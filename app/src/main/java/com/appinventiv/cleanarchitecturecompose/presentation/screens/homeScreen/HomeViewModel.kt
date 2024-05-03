package com.appinventiv.cleanarchitecturecompose.presentation.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appinventiv.cleanarchitecturecompose.domain.models.HomeQuoteModel
import com.appinventiv.cleanarchitecturecompose.domain.models.Quote
import com.appinventiv.cleanarchitecturecompose.domain.useCases.AllQuotesUseCase
import com.appinventiv.cleanarchitecturecompose.domain.useCases.RandomQuoteUseCase
import com.appinventiv.cleanarchitecturecompose.network.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val allQuotesUseCase: AllQuotesUseCase,
    private val randomQuoteUseCase: RandomQuoteUseCase
): ViewModel() {
    // We can use anyone of below
//    private val _quotedData = MutableStateFlow<NetworkState>(NetworkState.LOADING)
//    val quotesData : StateFlow<NetworkState> = _quotedData.asStateFlow()
    var quotedData = MutableStateFlow<NetworkState<HomeQuoteModel>>(NetworkState.LOADING())
    private set

    init {
        getQuotes();
    }

    private fun getQuotes() {
        quotedData.tryEmit(NetworkState.LOADING())
        allQuotesUseCase().combine(randomQuoteUseCase()) { allQuotes: List<Quote>?, randomQuote: Quote? ->
            quotedData.tryEmit(NetworkState.SUCCESS(HomeQuoteModel(
                randomQuote = randomQuote,
                allQuoteList = allQuotes )))
        }.launchIn(viewModelScope)
    }
}