package com.example.menuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class CounterApp : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.counterapp)
    }

    fun onTap(view: View) {
        count++
        val textview = findViewById(R.id.textView) as TextView
        textview.text = "You clicked $count times."
    }
}
