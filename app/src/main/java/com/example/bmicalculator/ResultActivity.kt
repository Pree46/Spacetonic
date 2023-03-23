package com.example.bmicalculator

import android.app.Instrumentation.ActivityResult
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.bmicalculator.databinding.ActivityMainBinding
import com.example.bmicalculator.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bmi = intent.getDoubleExtra("bmi", -1.0)
        if (bmi == -1.0){
            binding.containerR.visibility = View.GONE
        }
        else{
            binding.bmiValueTv.text = bmi.toString()
            if(bmi<18.5){
                binding.containerR.setBackgroundResource(R.drawable.yellow_bg)
                binding.bmiFlagImageView.setImageResource(R.drawable.baseline_warning_amber_24)
                binding.bmiLabelTv.text = "You have an UnderWeight"
                binding.commentTv.text = "Here are some advices to increase your weight"
                binding.advice1IMG.setImageResource(R.drawable.avacado)
                binding.advice1TXT.text = "Follow a nutrient rich high calorie diet"
                binding.advice2IMG.setImageResource(R.drawable.milk)
                binding.advice2TXT.text = "Take Low fat Dairy foods"
                binding.advice3IMG.setImageResource(R.drawable.soymilk)
                binding.advice3TXT.text = "Drink Soy milk"
            }else{
                if(bmi > 25){
                    binding.containerR.setBackgroundResource(R.drawable.red_bg)
                    binding.bmiFlagImageView.setImageResource(R.drawable.baseline_warning_amber_24)
                    binding.bmiLabelTv.text = "You have an OverWeight"
                    binding.commentTv.text = "Here are some advices to reduce your weight"
                    binding.advice1IMG.setImageResource(R.drawable.exercise)
                    binding.advice1TXT.text = "Exercise regularly to burn out excess calories"
                    binding.advice2IMG.setImageResource(R.drawable.water)
                    binding.advice2TXT.text = "Drink plenty of water"
                    binding.advice3IMG.setImageResource(R.drawable.nosugar)
                    binding.advice3TXT.text = "Reduce your sugar intake"
                }
            }
        }
    }
}