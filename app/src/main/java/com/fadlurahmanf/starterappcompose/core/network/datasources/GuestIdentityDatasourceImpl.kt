package com.fadlurahmanf.starterappcompose.core.network.datasources

import com.fadlurahmanf.starterappcompose.core.exception.BaseExceptionUtility
import com.fadlurahmanf.starterappcompose.core.network.api.IdentityApi
import com.fadlurahmanf.starterappcompose.core.network.dto.request.guest_token.GenerateGuestTokenRequest
import com.fadlurahmanf.starterappcompose.core.network.dto.response.guest_token.GenerateGuestTokenResponse
import io.reactivex.rxjava3.core.Observable
import java.util.UUID
import javax.inject.Inject

class GuestIdentityDatasourceImpl @Inject constructor(
    private val identityApi: IdentityApi
) : GuestIdentityDatasource {
    override fun generateGuestToken(): Observable<GenerateGuestTokenResponse> {
        val uuid = UUID.randomUUID()
        return identityApi.generateGuestToken(
            GenerateGuestTokenRequest(
                guestId = uuid.toString()
            )
        ).map {
            if (it.data.accessToken == null) {
                throw BaseExceptionUtility.toBaseApiExceptionGeneral("DATA_MISSING")
            }
            it.data
        }
    }

}