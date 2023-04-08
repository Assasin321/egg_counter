package com.example.eggcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eggcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var digit = 0

        binding.eggCircle.setOnClickListener{
            digit = (digit + 1) % 20
            binding.eggNumber.text = digit.toString()
        }

        binding.clearButton.setOnClickListener {
            digit = 0
            binding.eggNumber.text = digit.toString()
        }


    }
}