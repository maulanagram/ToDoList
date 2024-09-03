package com.maulana.di.module

import com.maulana.data.repository.AuthRepositoryImpl
import com.maulana.remote.datasource.LoginRemoteDataSource
import com.maulana.remote.service.LoginService
import com.maulana.repository.AuthRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AuthDataModule {

    @Singleton
    @Provides
    fun provideRepository(
        @Singleton authRemoteDataSource: LoginRemoteDataSource
    ): AuthRepository {
        return AuthRepositoryImpl(
            authRemoteDataSource
        )
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(
        @Singleton loginService: LoginService,
    ): LoginRemoteDataSource {
        return LoginRemoteDataSource(loginService)
    }

}