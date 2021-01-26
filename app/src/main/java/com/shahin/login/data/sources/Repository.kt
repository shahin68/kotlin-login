package com.shahin.login.data.sources

interface Repository {
    fun verify(
        username: String,
        password: String,
        passwordConfirmation: String
    ): Boolean
}