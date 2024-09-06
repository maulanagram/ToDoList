package com.maulana.todolist.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maulana.domain.model.ChecklistData
import com.maulana.domain.model.NoteData

//@Preview(showSystemUi = true)
@Composable
fun NoteItem(note:NoteData) {
    Card(
        colors = CardColors(
            containerColor = Color.Cyan,
            contentColor = Color.Black,
            disabledContentColor = Color.DarkGray,
            disabledContainerColor = Color.Gray
        ), shape = RoundedCornerShape(8.dp)
    ) {
        LazyColumn(userScrollEnabled = false,
            modifier = Modifier
                .padding(8.dp).fillMaxWidth().height(200.dp)
        ) {
            item{
                Text(text = note.title)
            }
            items(items = note.checklistData){checklistData->
                ChecklistItem(checked = checklistData.isChecked, title = checklistData.title)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun NoteItemPreview() {
    NoteItem(NoteData(1,"Test", listOf(ChecklistData(1,1,true,"Teeeeest"))))
}