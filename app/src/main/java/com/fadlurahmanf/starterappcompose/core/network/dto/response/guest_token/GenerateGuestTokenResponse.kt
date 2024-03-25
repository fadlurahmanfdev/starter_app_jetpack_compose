package com.fadlurahmanf.starterappcompose.core.network.dto.response.guest_token

data class GenerateGuestTokenResponse(
    val accessToken: String? = null,
    val expiresIn: Int? = null
)
