package com.maulana.todolist.ui.page.note

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.maulana.domain.model.ChecklistData
import com.maulana.domain.model.NoteData
import com.maulana.todolist.ui.component.NoteItem
import com.maulana.todolist.ui.component.Spacer
import com.maulana.util.GlobalDimension

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(navHostController: NavHostController) {
    var text by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val noteData by rememberSaveable { mutableStateOf(listOf<NoteData>(NoteData(1,"Test", listOf(
        ChecklistData(1,1,true,"Teeeeest")
    )),NoteData(2,"Test 2", listOf(
        ChecklistData(1,1,true,"Teeeeest 2")
    )))) }

    Column(Modifier.fillMaxWidth().padding(GlobalDimension.mainPadding)) {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth(),
            inputField = {
                SearchBarDefaults.InputField(
                    query = text,
                    onQueryChange = { text = it },
                    onSearch = { expanded = false },
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    placeholder = { Text("Hinted search text") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    trailingIcon = { Icon(Icons.Default.MoreVert, contentDescription = null) },
                )
            },
            expanded = expanded,
            onExpandedChange = { expanded = it },
        ) {

        }
        Spacer(16.dp)
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            content = {
                items(items = noteData) { note ->
                    NoteItem(note)
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
    NoteScreen(rememberNavController())
}