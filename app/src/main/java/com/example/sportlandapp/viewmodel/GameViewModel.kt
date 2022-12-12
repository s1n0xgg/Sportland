package com.example.sportlandapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportlandapp.ui.models.GameModel
import java.util.UUID

class GameViewModel : ViewModel() {
    private val _gamesList = MutableLiveData<List<GameModel>>(emptyList())
    val gameslist: LiveData<List<GameModel>> = _gamesList
    fun addgame(game: GameModel) {
        val oldlist = gameslist.value?.toMutableList()
        oldlist?.add(game)
        _gamesList.value = oldlist?.toList()
    }

    fun changegame(id: UUID) {
        val oldlist = gameslist.value?.toMutableList()
        val newgame = oldlist!!.find { it.Id == id }
        val index = oldlist.indexOf(newgame)
        newgame!!.MinPlayers +=1
        Log.d("value", newgame!!.MinPlayers.toString())
        if (newgame!!.MinPlayers == newgame!!.MaxPlayers)
            oldlist.removeAt(index)
        else
            oldlist[index] = newgame
        Log.d("value", oldlist.toString())
        _gamesList.value = oldlist.toList()
        Log.d("value", _gamesList.value.toString())
    }
}