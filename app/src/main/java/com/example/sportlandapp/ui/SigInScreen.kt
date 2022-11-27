package com.example.sportlandapp.ui


import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.FragmentSignInScreenBinding


class SigInScreen : Fragment(R.layout.fragment__sign_in_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSignInScreenBinding.bind(view)
        binding.buttonToRegisterScreen.setOnClickListener {
            findNavController().navigate(R.id.action_sigInScreen_to_registerScreen)
        }
        binding.buttonToFirstProfile.setOnClickListener {
            findNavController().navigate(R.id.action_sigInScreen_to_mainScreen)
        }
        binding.name2.typeface = Typeface.DEFAULT_BOLD
        binding.password2.typeface = Typeface.DEFAULT_BOLD
    }
}




