package com.maulana.todolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class LoginViewModel @Inject constructor(private val authRepository: AuthRepository,
                     private val dispatcher: CoroutineDispatcher,) : ViewModel(

) {

    fun login(userName: String, password: String) {
        viewModelScope.launch(dispatcher) {
            runCatching {
                _loadingNewPassword.postValue(true)
                authRepository.resetPassword(
                    newPassword = newPassword,
                    confirmNewPassword = confirmPassword,
                    forgetCode = forgetCode
                )
            }.onSuccess {
                _loadingNewPassword.postValue(false)
                _successNewPassword.postValue(it)
            }.onFailure {
                _loadingNewPassword.postValue(false)
                _errorNewPassword.postValue(it.message)
            }
        }
    }

}