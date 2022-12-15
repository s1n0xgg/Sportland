package com.example.sportlandapp.ui

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.checkSelfPermission

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.FragmentMainScreenBinding
import com.example.sportlandapp.databinding.FragmentProfileScreenBinding
import com.example.sportlandapp.viewmodel.UserViewModel
import kotlin.contracts.contract


class ProfileScreen : Fragment(R.layout.fragment__profile_screen) {
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding: FragmentProfileScreenBinding = FragmentProfileScreenBinding.bind(view)

        binding.user = userViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val galleryPermission = registerForActivityResult(ActivityResultContracts.GetContent()){
            binding.avatar.setImageURI(it)
        }
        binding.avatar.setOnClickListener{
            galleryPermission.launch("image/*")
        }
    }
}
