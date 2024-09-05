package com.maulana.di.module

import com.maulana.data.repository.NoteRepositoryImpl
import com.maulana.remote.datasource.NoteRemoteDataSource
import com.maulana.remote.service.NoteService
import com.maulana.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object NoteModule {

    @Provides
    fun provideNoteRepository(
        noteRemoteDataSource: NoteRemoteDataSource
    ): NoteRepository {
        return NoteRepositoryImpl(
            noteRemoteDataSource
        )
    }


    @Provides
    fun provideNoteRemoteDataSource(
        noteService: NoteService,
    ): NoteRemoteDataSource {
        return NoteRemoteDataSource(noteService)
    }

    @Provides
    fun provideNoteService(
        retrofit: Retrofit,
    ): NoteService {
        return retrofit.create(NoteService::class.java)
    }

}