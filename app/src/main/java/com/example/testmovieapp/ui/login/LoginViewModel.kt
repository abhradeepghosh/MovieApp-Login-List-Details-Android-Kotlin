package com.example.testmovieapp.ui.login

import android.view.View
import android.widget.EditText
import androidx.annotation.VisibleForTesting
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.example.testmovieapp.di.ui.BaseViewModel
import com.example.testmovieapp.ui.login.model.LoginFields
import com.example.testmovieapp.ui.login.model.LoginForm

/**
 * to set up the error
 */
@BindingAdapter("error")
fun setError(editText: EditText, strOrResId: Any?) {
    if (strOrResId is Int) {
        editText.error = editText.context.getString((strOrResId as Int?)!!)
    } else {
        editText.error = strOrResId as String?
    }
}

/**
 * to bind the focus change
 */
@BindingAdapter("onFocus")
fun bindFocusChange(
    editText: EditText,
    onFocusChangeListener: View.OnFocusChangeListener?
) {
    if (editText.onFocusChangeListener == null) {
        editText.onFocusChangeListener = onFocusChangeListener
    }
}

class LoginViewModel : BaseViewModel() {

    private var login: LoginForm? = null
    private var onFocusEmail: View.OnFocusChangeListener? = null
    private var onFocusPassword: View.OnFocusChangeListener? = null

    @VisibleForTesting
    fun init() {
        login = LoginForm()
        onFocusEmail = View.OnFocusChangeListener { view, focused ->
            val et = view as EditText
            if (et.text.length > 0 && !focused) {
                login?.isEmailValid(true)
            }
        }
        onFocusPassword = View.OnFocusChangeListener { view, focused ->
            val et = view as EditText
            if (et.text.length > 0 && !focused) {
                login?.isPasswordValid(true)
            }
        }
    }

    fun getLogin(): LoginForm? {
        return login
    }

    fun getEmailOnFocusChangeListener(): View.OnFocusChangeListener? {
        return onFocusEmail
    }

    fun getPasswordOnFocusChangeListener(): View.OnFocusChangeListener? {
        return onFocusPassword
    }

    fun onButtonClick() {
        login?.onClick()
    }

    fun getLoginFields(): MutableLiveData<LoginFields>? {
        return login?.getLoginFields()
    }

    fun getForm(): LoginForm? {
        return login
    }

}