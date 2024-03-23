package com.fadlurahmanf.starterappcompose.feature.crypto.helper.di

import com.fadlurahmanf.starterappcompose.feature.crypto.data.repositories.CryptoAESRepository
import com.fadlurahmanf.starterappcompose.feature.crypto.data.repositories.CryptoAESRepositoryImpl
import com.fadlurahmanf.starterappcompose.feature.crypto.data.repositories.CryptoED25119Repository
import com.fadlurahmanf.starterappcompose.feature.crypto.data.repositories.CryptoED25119RepositoryImpl
import com.fadlurahmanf.starterappcompose.feature.crypto.data.repositories.CryptoRSARSARepositoryImpl
import com.fadlurahmanf.starterappcompose.feature.crypto.data.repositories.CryptoRSARepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CryptoModule {

    @Provides
    fun provideCryptoRSARepository(): CryptoRSARepository {
        return CryptoRSARSARepositoryImpl()
    }

    @Provides
    fun provideCryptoAESRepository(): CryptoAESRepository {
        return CryptoAESRepositoryImpl()
    }

    @Provides
    fun provideCryptoED25119Repository(): CryptoED25119Repository {
        return CryptoED25119RepositoryImpl()
    }
}