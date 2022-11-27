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

class CreateGame : Fragment(R.layout.fragment__create_game) {
    private val GameViewModel: GameViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCreateGameBinding.bind(view)
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

        binding.mainCity.typeface = Typeface.DEFAULT_BOLD
        binding.space.typeface = Typeface.DEFAULT_BOLD
        binding.time.typeface = Typeface.DEFAULT_BOLD
        binding.mainSport.typeface = Typeface.DEFAULT_BOLD
        binding.numberPlayers.typeface = Typeface.DEFAULT_BOLD

        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_firstProfile_to_mainScreen)
            Toast.makeText(requireContext(), "Игра успешно создана!", Toast.LENGTH_SHORT).show()
            GameViewModel.addgame(
                GameModel(
                    binding.mainSport.editText!!.text.toString(),
                    binding.time.editText!!.text.toString(),
                    binding.mainCity.editText!!.text.toString(),
                )
            )
        }
    }
}
