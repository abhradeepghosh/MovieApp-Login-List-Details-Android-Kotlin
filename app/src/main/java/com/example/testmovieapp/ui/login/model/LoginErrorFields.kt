package com.example.testmovieapp.ui.login.model

class LoginErrorFields {

    private var email: Int? = null
    private var password: Int? = null

    /**
     * to get the email
     */
    fun getEmail(): Int? {
        return email
    }

    /**
     * to set the email
     */
    fun setEmail(email: Int?) {
        this.email = email
    }

    /**
     * to get the password
     */
    fun getPassword(): Int? {
        return password
    }

    /**
     * to set the password
     */
    fun setPassword(password: Int?) {
        this.password = password
    }

}