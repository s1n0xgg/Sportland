package com.example.sportlandapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.FragmentMainScreenBinding
import com.example.sportlandapp.ui.adaptors.GamesAdaptor
import com.example.sportlandapp.ui.models.GameModel
import com.example.sportlandapp.viewmodel.GameViewModel
import com.example.sportlandapp.viewmodel.UserViewModel
import java.util.*

class MainScreen : Fragment(R.layout.fragment__main_screen) {
    private val GameViewModel: GameViewModel by activityViewModels()
    private val userViewModel: UserViewModel by activityViewModels()
    private lateinit var binding: FragmentMainScreenBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainScreenBinding.bind(view)
        binding.createGameButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreen_to_firstProfile)
        }
        if (userViewModel.email.value.toString().isEmpty())
            findNavController().navigate(R.id.action_mainScreen_to_registerScreen4)
        binding.recyclerviewGames.adapter = GamesAdaptor(GameViewModel.gameslist.value!!) {
            updatePlayers(it)
        }

    }

    private fun updatePlayers(game: GameModel) {
        GameViewModel.changegame(game.Id)
        userViewModel.addGame(game.Id)
        binding.recyclerviewGames.adapter = GamesAdaptor(GameViewModel.gameslist.value!!) {
            updatePlayers(it)
        }
    }
}

