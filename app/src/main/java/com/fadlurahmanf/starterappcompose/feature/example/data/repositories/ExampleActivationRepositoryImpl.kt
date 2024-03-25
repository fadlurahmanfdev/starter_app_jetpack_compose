package com.fadlurahmanf.starterappcompose.feature.example.data.repositories

import com.fadlurahmanf.starterappcompose.core.network.datasources.GuestIdentityDatasource
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ExampleActivationRepositoryImpl @Inject constructor(
    private val guestIdentityRemoteDatasource: GuestIdentityDatasource
) : ExampleActivationRepository {
    override fun generateGuestToken(): Observable<Boolean> {
        return guestIdentityRemoteDatasource.generateGuestToken().map {
            true
        }
    }
}