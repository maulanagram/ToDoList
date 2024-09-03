package com.maulana.di.module

import com.maulana.data.repository.AuthRepositoryImpl
import com.maulana.remote.datasource.LoginRemoteDataSource
import com.maulana.remote.service.LoginService
import com.maulana.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object AuthDataModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: LoginRemoteDataSource
    ): AuthRepository {
        return AuthRepositoryImpl(
            authRemoteDataSource
        )
    }


    @Provides
    fun provideRemoteDataSource(
        loginService: LoginService,
    ): LoginRemoteDataSource {
        return LoginRemoteDataSource(loginService)
    }

}