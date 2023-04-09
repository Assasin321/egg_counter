package com.example.eggcounter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import com.example.eggcounter.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var digit = 0
    private val maxDigitValue = 501

    private fun getRandomColor(): Int {
        return Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val eggCircle = binding.eggCircle
        val eggNumber = binding.eggNumber
        val clearButton = binding.clearButton


        eggCircle.setOnClickListener {
            digit = (digit + 1) % maxDigitValue
            eggNumber.text = digit.toString()

            val shake = AnimationUtils.loadAnimation(this, R.anim.shake)
            eggCircle.startAnimation(shake)

            if (digit % 20 == 0) {
                eggNumber.setTextColor(getRandomColor())
            }
        }

        clearButton.setOnClickListener {
            digit = 0
            eggNumber.text = digit.toString()

            val shake = AnimationUtils.loadAnimation(this, R.anim.shake)
            eggNumber.startAnimation(shake)

            eggNumber.setTextColor(ContextCompat.getColor(this, R.color.black))
        }


    }
}