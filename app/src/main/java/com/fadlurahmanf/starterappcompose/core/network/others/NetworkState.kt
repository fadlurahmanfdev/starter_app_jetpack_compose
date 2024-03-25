package com.fadlurahmanf.starterappcompose.core.network.others

import com.fadlurahmanf.starterappcompose.core.exception.BaseException

sealed class NetworkState<out T : Any>() {
    data object IDLE : NetworkState<Nothing>()
    data object LOADING : NetworkState<Nothing>()
    data class SUCCESS<out T : Any>(val data: T) : NetworkState<T>()
    data class FAILED(val exception: BaseException) : NetworkState<Nothing>()
}