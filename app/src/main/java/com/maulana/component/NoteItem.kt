package com.maulana.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maulana.component.ChecklistItem

//@Preview(showSystemUi = true)
@Composable
fun NoteItem(title: String) {
    Card(Modifier.background(color = Color.Cyan)) {
        Column(
            Modifier
                .padding(8.dp).background(color = Color.Transparent)
        ) {
            Text(text = title)
            ChecklistItem(checked = false, title = "Item 1")
        }
    }
}

@Preview
@Composable
fun NoteItemPreview() {
    NoteItem(title = "Test")
}