package com.maulana.remote.datasource

import com.maulana.domain.model.NoteData
import com.maulana.remote.service.NoteService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRemoteDataSource(private val service: NoteService) {

    fun getAllNotes(token: String): Flow<List<NoteData>> {
        return service.getAllNotes(token).map {
            it.payload.map {data-> NoteData(data.noteId, data.title, data.checklistData) }
        }
    }

}