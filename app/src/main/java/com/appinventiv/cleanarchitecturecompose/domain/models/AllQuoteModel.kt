package com.appinventiv.cleanarchitecturecompose.domain.models

import com.google.gson.annotations.SerializedName

data class AllQuoteModel(
    @SerializedName("quotes")
    val quotes: List<Quote>? = null
)