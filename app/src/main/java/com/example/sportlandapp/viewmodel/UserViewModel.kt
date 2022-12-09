package com.example.sportlandapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.UUID

class UserViewModel : ViewModel() {
    private val _playersGames = MutableLiveData<List<UUID>>(emptyList())
    private val _mainCity = MutableLiveData<String>("")
    private val _name = MutableLiveData<String>("")
    private val _password = MutableLiveData<String>("")
    val playersGames: LiveData<List<UUID>> = _playersGames
    val email: LiveData<String> = _mainCity
    val name: LiveData<String> = _name
    val password: LiveData<String> = _password

    fun changeUserData(email: String, name: String, password: String) {
        _mainCity.value = email
        _name.value = name
        _password.value = password
    }
    fun addGame(id: UUID){
        val oldlist = playersGames.value?.toMutableList()
        oldlist?.add(id)
        _playersGames.value = oldlist?.toList()
    }
}