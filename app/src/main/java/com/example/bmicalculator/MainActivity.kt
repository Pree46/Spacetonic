package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBtn.setOnClickListener {
            if (binding.heightEDTX.text.isNotEmpty() && binding.wightEDTX.text.isNotEmpty()){
                val weight = binding.wightEDTX.text.toString().toDouble()
                val height = binding.heightEDTX.text.toString().toDouble()/100

                if (weight>0 && weight<600 && height>=0.50 && height<2.5){
                    val intent = Intent(this@MainActivity, ResultActivity::class.java)
                    intent.putExtra("bmi", calculateBMI(weight, height))
                    startActivity(intent)
                }
                else{
                    showError("Incorrect Values")
                }
            }else{
                showError("A field is missing")
            }
        }
    }
    private fun showError(errorMsg: String){
        val snackbar = Snackbar.make(binding.container, "error: $errorMsg !", Snackbar.LENGTH_LONG)
        snackbar.view.setBackgroundResource(R.color.colorRed)
    }
    private fun calculateBMI(weight: Double, height: Double) = BigDecimal(weight/(height*height))
        .setScale(2, RoundingMode.HALF_EVEN).toDouble()
}