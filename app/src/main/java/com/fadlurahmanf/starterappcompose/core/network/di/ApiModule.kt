package com.fadlurahmanf.starterappcompose.core.network.di

import com.fadlurahmanf.starterappcompose.core.network.api.IdentityApi
import com.fadlurahmanf.starterappcompose.core.network.others.NetworkUtilities
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    private val networkUtilities = NetworkUtilities()

    @Provides
    fun provideIdentityNetwork(): IdentityApi {
        return networkUtilities.createGuestIdentityNetwork(
            networkUtilities.okHttpClientBuilder().build()
        )
    }
}