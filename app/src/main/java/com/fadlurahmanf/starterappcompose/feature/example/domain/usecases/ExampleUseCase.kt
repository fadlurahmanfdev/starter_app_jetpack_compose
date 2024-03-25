package com.fadlurahmanf.starterappcompose.feature.example.domain.usecases

import io.reactivex.rxjava3.core.Observable

interface ExampleUseCase {
    fun generateGuestToken(): Observable<Boolean>
}