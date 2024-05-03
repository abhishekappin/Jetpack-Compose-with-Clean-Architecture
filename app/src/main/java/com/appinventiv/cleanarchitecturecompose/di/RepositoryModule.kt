package com.appinventiv.cleanarchitecturecompose.di

import com.appinventiv.cleanarchitecturecompose.data.remote.ApiInterface
import com.appinventiv.cleanarchitecturecompose.data.repositoryImpl.QuoteRepositoryImpl
import com.appinventiv.cleanarchitecturecompose.domain.repository.QuoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun getQuotesRepository(
        apiInterface: ApiInterface
    ) : QuoteRepository = QuoteRepositoryImpl(apiInterface = apiInterface)
}