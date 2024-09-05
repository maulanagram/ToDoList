package com.maulana.di.module

import com.maulana.data.repository.AuthRepositoryImpl
import com.maulana.remote.datasource.LoginRemoteDataSource
import com.maulana.remote.service.LoginService
import com.maulana.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

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
    fun provideLoginRemoteDataSource(
        loginService: LoginService,
    ): LoginRemoteDataSource {
        return LoginRemoteDataSource(loginService)
    }

    @Provides
    fun provideLoginService(
        retrofit: Retrofit,
    ): LoginService {
        return retrofit.create(LoginService::class.java)
    }

}