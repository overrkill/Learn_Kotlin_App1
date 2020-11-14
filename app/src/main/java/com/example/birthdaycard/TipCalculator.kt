package com.example.birthdaycard

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.birthdaycard.databinding.ActivityTipCalculatorBinding
import java.text.NumberFormat

class TipCalculator : AppCompatActivity() {
    private lateinit var  binding: ActivityTipCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.claculate.setOnClickListener{ calculateTip() }
    }
    private fun calculateTip(){
        val stringInTextField = binding.costOfServiceEditText.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if(cost==null){
            val  toast = Toast.makeText(this,"Enter a Value",Toast.LENGTH_SHORT)
            toast.show()
            return
        }
        val tipPercent = when(binding.tipOptions.checkedRadioButtonId){
            R.id.tip_option_20 -> 0.20
            R.id.tip_option_18 -> 0.18
            else -> 0.15

        }

        var tip = cost*tipPercent

        val roundUp = binding.roundUpSwitch.isChecked
        if (roundUp){
            tip = kotlin.math.ceil(tip)
        }

        val formatTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipAmount.text = getString(R.string.tip_amount,formatTip)
    }
}