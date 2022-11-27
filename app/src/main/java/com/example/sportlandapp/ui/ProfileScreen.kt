package com.example.sportlandapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.FragmentProfileScreenBinding
import com.example.sportlandapp.viewmodel.UserViewModel


class ProfileScreen : Fragment(R.layout.fragment__profile_screen){
    private val userViewModel: UserViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding: FragmentProfileScreenBinding = FragmentProfileScreenBinding.bind(view)

        binding.user = userViewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }
}
