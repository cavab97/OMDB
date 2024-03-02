package com.example.omdb.ui.theme.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.omdb.R
import com.example.omdb.databinding.IntroPageBinding
import com.example.omdb.ui.theme.Auth.MainActivity
import com.example.omdb.ui.theme.Auth.SignInActivity


class IntroPage : Fragment() {

    private lateinit var binding:IntroPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = IntroPageBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.introLogin.setOnClickListener {
            if(requireActivity() is MainActivity){
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            } else if(requireActivity() is FrameLayoutActivity){
                requireActivity().supportFragmentManager.beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_in_left)
                    .replace(R.id.flMain, SignInActivity::class.java, null)
                    .commit()
            }
        }
    }
}