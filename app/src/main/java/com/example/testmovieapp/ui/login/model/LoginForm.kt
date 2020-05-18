package com.example.testmovieapp.ui.login.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.example.testmovieapp.BR
import com.example.testmovieapp.R

class LoginForm : BaseObservable() {

    private val fields = LoginFields()
    private val errors = LoginErrorFields()
    private val buttonClick = MutableLiveData<LoginFields>()

    /**
     * to check the password validity
     */
    @Bindable
    fun isValid(): Boolean {
        var valid: Boolean = isEmailValid(false)
        valid = isPasswordValid(false) && valid
        notifyPropertyChanged(BR.emailError)
        notifyPropertyChanged(BR.passwordError)
        return valid
    }

    /**
     * to check the email validity
     */
    fun isEmailValid(setMessage: Boolean): Boolean {
        // Minimum a@b.c
        val email = fields.getEmail()
        if (email != null && email.length > 5) {
            val indexOfAt = email.indexOf("@")
            val indexOfDot = email.lastIndexOf(".")
            return if (indexOfAt > 0 && indexOfDot > indexOfAt && indexOfDot < email.length - 1) {
                errors.setEmail(null)
                notifyPropertyChanged(BR.valid)
                true
            } else {
                if (setMessage) {
                    errors.setEmail(R.string.error_format_invalid)
                    notifyPropertyChanged(BR.valid)
                }
                false
            }
        }
        if (setMessage) {
            errors.setEmail(R.string.error_too_short)
            notifyPropertyChanged(BR.valid)
        }
        return false
    }

    /**
     * to validate password
     */
    fun isPasswordValid(setMessage: Boolean): Boolean {
        val password = fields.getPassword()
        return if (password != null && password.length > 5) {
            errors.setPassword(null)
            notifyPropertyChanged(BR.valid)
            true
        } else {
            if (setMessage) {
                errors.setPassword(R.string.error_too_short)
                notifyPropertyChanged(BR.valid)
            }
            false
        }
    }

    /**
     * to handle onClick
     */
    fun onClick() {
        if (isValid()) {
            buttonClick.value = fields
        }
    }

    /**
     * to retrieve the login field as a livedata
     */
    fun getLoginFields(): MutableLiveData<LoginFields>? {
        return buttonClick
    }

    /**
     * to retrieve the login field
     */
    fun getFields(): LoginFields? {
        return fields
    }

    /**
     * to get the email error
     */
    @Bindable
    fun getEmailError(): Int? {
        return errors.getEmail()
    }

    /**
     * to get the password error
     */
    @Bindable
    fun getPasswordError(): Int? {
        return errors.getPassword()
    }


}