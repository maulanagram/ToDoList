package com.maulana.repository

import com.maulana.domain.model.NoteData
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes(token: String): Flow<List<NoteData>>

}