package com.shahin.login.ui.fragments.login.units

object LoginValidation {

    fun validateInputs(
        username: String,
        password: String,
        passwordConfirmation: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty() || passwordConfirmation.isEmpty() || !passwordConfirmation.equals(password, false)) {
            return false
        }
        return true
    }

}