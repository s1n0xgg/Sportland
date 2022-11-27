package com.example.sportlandapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val _email = MutableLiveData<String>("")
    private val _name = MutableLiveData<String>("")
    private val _password = MutableLiveData<String>("")
    val email: LiveData<String> = _email
    val name: LiveData<String> = _name
    val password: LiveData<String> = _password

    fun changeUserData(email: String, name: String, password: String) {
        _email.value = email
        _name.value = name
        _password.value = password
    }
}