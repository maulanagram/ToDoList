package com.maulana.todolist.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//@Preview(showSystemUi = true)
@Composable
fun NoteItem(title: String) {
    Card(
        colors = CardColors(
            containerColor = Color.Cyan,
            contentColor = Color.Black,
            disabledContentColor = Color.DarkGray,
            disabledContainerColor = Color.Gray
        ), shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            Modifier
                .padding(8.dp)
        ) {
            Text(text = title)
            ChecklistItem(checked = false, title = "Item 1")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun NoteItemPreview() {
    NoteItem(title = "Test")
}