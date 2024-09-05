package com.maulana.domain.model

data class ChecklistData(
    val noteId:Int,
    val checklistId:Int,
    val isChecked:Boolean,
    val title:String
)
