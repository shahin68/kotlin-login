package com.shahin.login.ui.fragments.login

import androidx.lifecycle.ViewModel
import com.shahin.login.data.sources.Repository

class LoginViewModel(
    private val repository: Repository
) : ViewModel() {

    fun verifyInputs(
        username: String,
        password: String,
        passwordConfirmation: String
    ): Boolean {
        return repository.verify(
            username,
            password,
            passwordConfirmation
        )
    }

}