package com.example.sportlandapp.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.FragmentCreateGameBinding
import com.example.sportlandapp.ui.models.GameModel
import com.example.sportlandapp.viewmodel.GameViewModel
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import java.util.UUID

class CreateGame : Fragment(R.layout.fragment__create_game) {
    private lateinit var binding: FragmentCreateGameBinding
    private val GameViewModel: GameViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateGameBinding.bind(view)
        val items = arrayOf(
            "Тобольск",
            "Тюмень",
            "Заводоуковск",
            "Ишим",
            "Ялуторовск",
            "Тобольский район"
        )
        (binding.mainCity.editText as? MaterialAutoCompleteTextView)?.setSimpleItems(items)

        val item = arrayOf(
            "Баскетбол",
            "Футбол",
            "Воллейбол",
            "Теннис",
            "Велоспорт",
            "Лыжи",
            "Бег",
            "Хоккей"
        )
        (binding.mainSport.editText as? MaterialAutoCompleteTextView)?.setSimpleItems(item)

        binding.apply {
            mainCity.typeface = Typeface.DEFAULT_BOLD
            space.typeface = Typeface.DEFAULT_BOLD
            time.typeface = Typeface.DEFAULT_BOLD
            mainSport.typeface = Typeface.DEFAULT_BOLD
            numberPlayers.typeface = Typeface.DEFAULT_BOLD
            button2.setOnClickListener { toNextScreen() }
        }
    }

    private fun toNextScreen() {
        if (binding.space.editText!!.text.toString().isEmpty() ||
            binding.time.editText!!.text.toString().isEmpty() ||
            binding.mainSport.editText!!.text.toString().isEmpty() ||
            binding.numberPlayers.editText!!.text.toString().isEmpty() ||
            binding.mainCity.editText!!.text.toString().isEmpty()
        ) Toast.makeText(
            requireContext(), "Заполните поля", Toast.LENGTH_SHORT
        ).show()
        else {
            GameViewModel.addgame(
                GameModel(
                    Title = binding.mainSport.editText!!.text.toString(),
                    Time = binding.time.editText!!.text.toString(),
                    City = binding.mainCity.editText!!.text.toString(),
                    Space = binding.space.editText!!.text.toString(),
                    MaxPlayers = binding.numberPlayers.editText!!.text.toString().toInt(),
                    Id = UUID.randomUUID()
                )
            )
            findNavController().navigate(R.id.action_firstProfile_to_mainScreen)
        }
    }
}

