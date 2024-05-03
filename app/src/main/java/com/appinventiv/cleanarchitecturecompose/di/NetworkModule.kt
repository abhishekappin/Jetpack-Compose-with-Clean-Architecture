package com.appinventiv.cleanarchitecturecompose.di

import com.appinventiv.cleanarchitecturecompose.data.remote.ApiInterface
import com.appinventiv.cleanarchitecturecompose.network.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @Named("base_url")
    fun getBaseUrl() : String = BASE_URL

    @Singleton
    @Provides
    @Named("base_url_1")
    fun getBaseUrl1() : String = BASE_URL

    @Singleton
    @Provides
    fun getRetrofitClient(
        @Named("base_url") baseUrl : String
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun getApiClient(
        retrofit: Retrofit
    ) : ApiInterface = retrofit.create(ApiInterface::class.java)

}