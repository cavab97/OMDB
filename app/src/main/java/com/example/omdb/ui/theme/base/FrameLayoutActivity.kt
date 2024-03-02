package com.example.omdb.ui.theme.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.omdb.R
import com.example.omdb.databinding.ActivityFrameLayoutBinding

class FrameLayoutActivity: AppCompatActivity() {

    private lateinit var binding: ActivityFrameLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrameLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.flMain, IntroPage::class.java, null).commit()

    }

}