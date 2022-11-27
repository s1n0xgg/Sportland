package com.example.sportlandapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportlandapp.ui.models.GameModel

class GameViewModel: ViewModel() {
    private val _gamesList = MutableLiveData<List<GameModel>>(emptyList())
    val gameslist: LiveData<List<GameModel>> = _gamesList
    fun addgame(game: GameModel){
        val oldlist = gameslist.value?.toMutableList()
        oldlist?.add(game)
        _gamesList.value = oldlist?.toList()
    }

}