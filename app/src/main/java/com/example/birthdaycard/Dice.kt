package com.example.birthdaycard

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class diceRoll(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}

class Dice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
//            val toast = Toast.makeText(this,"Dice Rolled",Toast.LENGTH_SHORT)
//            toast.show()
//            val resultTextView: TextView = findViewById(R.id.textView3)
//            resultTextView.text = "6"
            rollDice()

        }
    }

    fun goTip(view:View){

        val intent = Intent(this,TipCalculator::class.java)
        startActivity(intent)
    }
    private fun rollDice() {
        val dice = diceRoll(6)
        val diceNum = dice.roll()
//        val resultTextView: TextView = findViewById(R.id.textView3)
//        resultTextView.text = diceNum.toString()
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.contentDescription = diceNum.toString()
//        diceImage.setImageResource(R.drawable.dice_2)
        val drawableResource = when (diceNum) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }
}