package com.fadlurahmanf.starterappcompose.core.network.api

import com.fadlurahmanf.starterappcompose.core.network.dto.request.guest_token.GenerateGuestTokenRequest
import com.fadlurahmanf.starterappcompose.core.network.dto.response.guest_token.GenerateGuestTokenResponse
import com.fadlurahmanf.starterappcompose.core.network.dto.response.others.MerchantBaseResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface IdentityApi {
    @POST("guest/session/create")
    fun generateGuestToken(
        @Body generateGuestTokenRequest: GenerateGuestTokenRequest
    ): Observable<MerchantBaseResponse<GenerateGuestTokenResponse>>
}