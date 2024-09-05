package com.maulana.todolist.ui.page.register

import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maulana.repository.AuthRepository
import com.maulana.util.saveToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val dispatcher: CoroutineDispatcher, private val sharedPreferences: SharedPreferences
) : ViewModel(

) {

    val registerLoading = mutableStateOf(false)
    val registerSuccess = mutableStateOf(false)

    val userName = mutableStateOf("")
    val password = mutableStateOf("")
    val errorMessage = mutableStateOf("")

    fun register() {
        viewModelScope.launch(dispatcher) {
            /*runCatching {
                registerLoading.value = true
                authRepository.register(userName.value, password.value)
            }.onSuccess { response ->
                if (response.token.orEmpty().isNotEmpty()) {
                    sharedPreferences.saveToken(response.token!!)
                    registerLoading.value = false
                    registerSuccess.value = true
                }
            }.onFailure {
                errorMessage.value = it.message.orEmpty()
                registerLoading.value = false
                registerSuccess.value = false
            }*/
        }
    }

}