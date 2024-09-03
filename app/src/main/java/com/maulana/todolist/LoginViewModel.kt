package com.maulana.todolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maulana.repository.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val authRepository: AuthRepository,
                                         private val dispatcher: CoroutineDispatcher,) : ViewModel(

) {

    fun login(userName: String, password: String) {
        viewModelScope.launch(dispatcher) {
            runCatching {
                authRepository.login(userName, password)
            }.onSuccess {
            }.onFailure {

            }
        }
    }

}