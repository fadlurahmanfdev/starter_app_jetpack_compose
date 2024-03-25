package com.fadlurahmanf.starterappcompose.feature.example.others.di

import com.fadlurahmanf.starterappcompose.core.network.datasources.GuestIdentityDatasource
import com.fadlurahmanf.starterappcompose.core.network.di.NetworkModule
import com.fadlurahmanf.starterappcompose.feature.example.data.repositories.ExampleActivationRepository
import com.fadlurahmanf.starterappcompose.feature.example.data.repositories.ExampleActivationRepositoryImpl
import com.fadlurahmanf.starterappcompose.feature.example.domain.usecases.ExampleUseCase
import com.fadlurahmanf.starterappcompose.feature.example.domain.usecases.ExampleUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
object ExampleModule {
    @Provides
    fun provideExampleActivationRepository(guestIdentityDatasource: GuestIdentityDatasource): ExampleActivationRepository {
        return ExampleActivationRepositoryImpl(guestIdentityDatasource)
    }

    @Provides
    fun provideExampleUseCase(exampleActivationRepository: ExampleActivationRepository): ExampleUseCase {
        return ExampleUseCaseImpl(exampleActivationRepository)
    }
}