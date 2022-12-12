package com.example.sportlandapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        binding.screen = this
    }
    fun photoPicker() {
        Toast.makeText(
            requireContext(), "Фото успешно выбрано!", Toast.LENGTH_SHORT
        ).show()
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        val REQUEST_CODE = 1
//        startActivityForResult(intent, REQUEST_CODE)
    }
}
