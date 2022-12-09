package com.example.sportlandapp.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.FragmentRegisterSreenBinding
import com.example.sportlandapp.viewmodel.UserViewModel
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class RegisterScreen : Fragment(R.layout.fragment__register_sreen) {
    private lateinit var binding: FragmentRegisterSreenBinding
    private val userViewModel: UserViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterSreenBinding.bind(view)
        val passwordEditText = binding.passwordLayout
        passwordEditText.editText?.doOnTextChanged { text, _, _, _ ->
            if (text?.length!! < 8)
                passwordEditText.error = "Пароль должен иметь не менее 8 символов"
            else
                passwordEditText.error = null
        }

        binding.loginLayout.typeface = Typeface.DEFAULT_BOLD
        binding.passwordLayout.typeface = Typeface.DEFAULT_BOLD
        binding.nameLayout.typeface = Typeface.DEFAULT_BOLD
        binding.mainCity.typeface = Typeface.DEFAULT_BOLD
        binding.buttonLayout.setOnClickListener {
            toNextScreen()
        }

        binding.signInButton.setOnClickListener {
            findNavController().navigate(R.id.action_registerScreen_to_sigInScreen)
        }
        val items = arrayOf(
            "Тобольск",
            "Тюмень",
            "Заводоуковск",
            "Ишим",
            "Ялуторовск",
            "Тобольский район"
        )
        (binding.mainCity.editText as? MaterialAutoCompleteTextView)?.setSimpleItems(items)
    }

    private fun toNextScreen() {
        if (binding.nameLayout.editText!!.text.toString().isEmpty() ||

            binding.loginLayout.editText!!.text.toString().isEmpty() ||
            !binding.loginLayout.editText!!.text.toString().contains("@")
            ||
            binding.passwordLayout.editText!!.text.toString().isEmpty() ||
            binding.mainCity.editText!!.text.toString().isEmpty()

        ) Toast.makeText(
            requireContext(), "Заполните поля", Toast.LENGTH_SHORT
        ).show()
        else {
            userViewModel.changeUserData(
                name = binding.nameLayout.editText!!.text.toString(),
                email = binding.mainCity.editText!!.text.toString(),
                password = binding.passwordLayout.editText!!.text.toString()
            )
            findNavController().navigate(R.id.action_registerScreen_to_mainScreen)
        }
    }
}



