package com.maulana.remote.response

import com.google.gson.annotations.SerializedName
import com.maulana.domain.model.ChecklistData

data class NoteResponse(
    @SerializedName("noteId")
    val noteId:Int,
    @SerializedName("title")
    val title:String,
    @SerializedName("checklist")
    val checklistData :List<ChecklistData>
)
