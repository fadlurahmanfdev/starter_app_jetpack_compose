package com.fadlurahmanf.starterappcompose.feature.example.presentation.api

import androidx.lifecycle.ViewModel
import com.fadlurahmanf.starterappcompose.core.exception.BaseException
import com.fadlurahmanf.starterappcompose.core.network.others.NetworkState
import com.fadlurahmanf.starterappcompose.feature.example.domain.usecases.ExampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ExampleApiViewModel @Inject constructor(
    private val exampleUseCase: ExampleUseCase
) : ViewModel() {

    val disposable = CompositeDisposable()

    private val _generateGuestTokenState: MutableStateFlow<NetworkState<Boolean>> =
        MutableStateFlow(NetworkState.IDLE)
    val generateGuestTokenState: StateFlow<NetworkState<Boolean>> =
        _generateGuestTokenState.asStateFlow()

    fun generateGuestToken() {
        _generateGuestTokenState.value = NetworkState.LOADING
        disposable.add(exampleUseCase.generateGuestToken().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _generateGuestTokenState.value = NetworkState.SUCCESS(it)
                },
                {
                    _generateGuestTokenState.value = NetworkState.FAILED(BaseException.default())
                },
                {}
            ))
    }
}