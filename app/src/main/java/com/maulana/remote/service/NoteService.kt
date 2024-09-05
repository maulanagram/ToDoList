package com.maulana.remote.service

import com.maulana.remote.response.BaseResponse
import com.maulana.remote.response.NoteResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Header

interface NoteService {

    @GET("/checklist")
    fun getAllNotes(@Header("authorization") token:String): Flow<BaseResponse<List<NoteResponse>>>



}