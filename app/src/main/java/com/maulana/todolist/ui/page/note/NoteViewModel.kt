package com.maulana.todolist.ui.page.note

import android.content.SharedPreferences
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maulana.domain.model.NoteData
import com.maulana.repository.NoteRepository
import com.maulana.util.loadToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    private val dispatcher: CoroutineDispatcher,
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    val noteList: MutableState<List<NoteData>> = mutableStateOf(listOf())
    val errorMessage = mutableStateOf("")

    init {
        getAllNotes()
    }


    private fun getAllNotes(){
        viewModelScope.launch(dispatcher) {
            runCatching {
                noteRepository.getAllNotes(sharedPreferences.loadToken().orEmpty())
            }.onSuccess {
                it.collect{data->
                    noteList.value = data
                }
            }.onFailure {
                errorMessage.value = it.message.orEmpty()
            }
        }
    }



}