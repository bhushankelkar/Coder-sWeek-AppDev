package com.example.menuapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var click = findViewById<View>(R.id.button6) as Button
        var click1 = findViewById<View>(R.id.button5) as Button

        click.setOnClickListener(){
            val intent = Intent(this,CounterApp::class.java)
            startActivity(intent)
        }
        click1.setOnClickListener(){
            val intent = Intent(this,CardLayout::class.java)
            startActivity(intent)
        }
        }
}
