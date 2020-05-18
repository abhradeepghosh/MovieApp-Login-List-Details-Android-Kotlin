package com.example.testmovieapp.ui.login.model

class LoginFields {

    private var email: String? = null
    private var password: String? = null

    /**
     * to get the email
     */
    fun getEmail(): String? {
        return email
    }

    /**
     * to set the email
     */
    fun setEmail(email: String?) {
        this.email = email
    }

    /**
     * to get the password
     */
    fun getPassword(): String? {
        return password
    }

    /**
     * to set the password
     */
    fun setPassword(password: String?) {
        this.password = password
    }
}