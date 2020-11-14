package com.example.birthdaycard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_MESSAGE = "com.example.birthdaycard.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun doSomething(view : View) {
        // I meed to do something here
//        val editText = findViewById<TextView>(R.id.editText)
//        val message = editText.text.toString()
        val intent = Intent(this, Dice::class.java)
//            .apply {
//            putExtra(EXTRA_MESSAGE,message)
//        }
        startActivity(intent)
    }
}