package com.maulana.domain.model

data class NoteData(
    val noteId:Int,
    val title:String,
    val checklistData :List<ChecklistData>
)
