package com.fadlurahmanf.starterappcompose.core.network.di

import com.fadlurahmanf.starterappcompose.core.network.api.IdentityApi
import com.fadlurahmanf.starterappcompose.core.network.datasources.GuestIdentityDatasource
import com.fadlurahmanf.starterappcompose.core.network.datasources.GuestIdentityDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [ApiModule::class])
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideIdentityDatasourceModule(identityApi: IdentityApi): GuestIdentityDatasource {
        return GuestIdentityDatasourceImpl(identityApi)
    }
}