package com.maulana.di.module

import com.google.gson.GsonBuilder
import com.maulana.remote.response.LoginResponse
import com.maulana.remote.service.LoginService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class RestModule {

    private val BASE_URL = "http://94.74.86.174:8080/api"

    @Singleton
    @Provides
    @Named("rest")
    fun provideRetrofitBuilder(
        @Named("rest") okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    @Named("login")
    fun provideRetrofitBuilderLogin(
        @Named("rest") okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    @Named("rest")
    fun provideRestOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .build()
    }

    @Singleton
    @Provides
    fun provideLoginService(
        @Named("rest") retrofit: Retrofit,
    ): LoginService {
        return retrofit.create(LoginService::class.java)
    }

}