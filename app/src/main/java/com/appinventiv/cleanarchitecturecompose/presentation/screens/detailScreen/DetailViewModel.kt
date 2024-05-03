package com.appinventiv.cleanarchitecturecompose.presentation.screens.detailScreen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appinventiv.cleanarchitecturecompose.domain.models.Quote
import com.appinventiv.cleanarchitecturecompose.domain.useCases.GetSingleQuoteUseCase
import com.appinventiv.cleanarchitecturecompose.network.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val singleQuoteUseCase: GetSingleQuoteUseCase
) : ViewModel() {

    var singleQuoteData = MutableStateFlow<NetworkState<Quote?>>(NetworkState.LOADING())
    init {
        getSingleQuote(savedStateHandle.get<String>("id") ?: "")
    }

    private fun getSingleQuote(id: String) {
        singleQuoteData.tryEmit(NetworkState.LOADING())
        Log.d("Dev_No_Limit", "${id}")
        singleQuoteUseCase(id).onEach {
            singleQuoteData.tryEmit(NetworkState.SUCCESS(it))
        }.launchIn(viewModelScope)

    }
}