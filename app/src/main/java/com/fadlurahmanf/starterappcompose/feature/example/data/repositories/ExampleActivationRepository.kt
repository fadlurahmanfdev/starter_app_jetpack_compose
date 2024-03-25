package com.fadlurahmanf.starterappcompose.feature.example.data.repositories

import io.reactivex.rxjava3.core.Observable

interface ExampleActivationRepository {
    fun generateGuestToken(): Observable<Boolean>
}