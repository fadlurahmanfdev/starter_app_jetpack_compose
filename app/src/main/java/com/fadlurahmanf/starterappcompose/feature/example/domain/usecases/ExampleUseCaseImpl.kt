package com.fadlurahmanf.starterappcompose.feature.example.domain.usecases

import com.fadlurahmanf.starterappcompose.feature.example.data.repositories.ExampleActivationRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ExampleUseCaseImpl @Inject constructor(
    private val exampleActivationRepository: ExampleActivationRepository
) : ExampleUseCase {
    override fun generateGuestToken(): Observable<Boolean> {
        return exampleActivationRepository.generateGuestToken()
    }

}