package com.shahin.login.data.sources

class RepositoryImpl: Repository {
    override fun verify(
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