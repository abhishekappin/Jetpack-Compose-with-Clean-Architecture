package com.appinventiv.cleanarchitecturecompose.network

sealed class NetworkState<T> {
    class LOADING<T> : NetworkState<T>()
    data class SUCCESS<T>(val data : T) : NetworkState<T>()
    data class ERROR<T>(val error : Any) : NetworkState<T>()

}