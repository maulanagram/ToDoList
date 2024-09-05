package com.maulana.data.repository

import com.maulana.domain.model.NoteData
import com.maulana.remote.datasource.NoteRemoteDataSource
import com.maulana.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val noteRemoteDataSource: NoteRemoteDataSource) :NoteRepository {

    override fun getAllNotes(token: String): Flow<List<NoteData>> {
        return noteRemoteDataSource.getAllNotes(token)
    }
}