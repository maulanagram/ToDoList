package com.maulana.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun ChecklistItem(checked: Boolean, title: String) {
    Row(verticalAlignment = Alignment.CenterVertically){
        Checkbox(checked = checked, onCheckedChange = {})
        Text(text = title)
    }
}