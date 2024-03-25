package com.fadlurahmanf.starterappcompose.core.network.datasources

import com.fadlurahmanf.starterappcompose.core.network.dto.response.guest_token.GenerateGuestTokenResponse
import io.reactivex.rxjava3.core.Observable

interface GuestIdentityDatasource {
    fun generateGuestToken(): Observable<GenerateGuestTokenResponse>
}