package com.example.testmovieapp.login

import com.example.testmovieapp.ui.login.LoginViewModel
import com.example.testmovieapp.ui.login.model.LoginForm
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class LoginFormTest {

    @Test
    fun fields_isCorrect() {
        val vm = LoginViewModel()
        vm.init()
        val form: LoginForm = vm.getForm()!!
        form.getFields()?.setEmail("Hello@world.com")
        form.getFields()?.setPassword("123456")
        Assert.assertTrue("Form is not valid", form.isValid())
    }

    @Test
    fun email_isShort() {
        val vm = LoginViewModel()
        vm.init()
        val form = vm.getForm()
        form!!.getFields()!!.setEmail("a@b.c")
        form.getFields()!!.setPassword("123456")
        Assert.assertTrue("Email should be invalid", !form.isEmailValid(true))
        Assert.assertTrue("Password should be valid", form.isPasswordValid(false))
        Assert.assertTrue("Form is valid, email should be invalid", !form.isValid())
    }

    @Test
    fun email_isWrongFormat() {
        val vm = LoginViewModel()
        vm.init()
        val form = vm.getForm()
        form!!.getFields()!!.setEmail("aaa@baac")
        form.getFields()!!.setPassword("123456")
        Assert.assertTrue("Email should be invalid", !form.isEmailValid(true))
        Assert.assertTrue("Password should be valid", form.isPasswordValid(false))
        Assert.assertTrue("Form is invalid, email should be invalid", !form.isValid())
    }

    @Test
    fun password_isShort() {
        val vm = LoginViewModel()
        vm.init()
        val form = vm.getForm()
        form!!.getFields()!!.setEmail("a@b.cc")
        form.getFields()!!.setPassword("1234")
        Assert.assertTrue("Email should be valid", form.isEmailValid(false))
        Assert.assertTrue("Password should be invalid", !form.isPasswordValid(true))
        Assert.assertTrue("Form is invalid, password should be invalid", !form.isValid())
    }

}