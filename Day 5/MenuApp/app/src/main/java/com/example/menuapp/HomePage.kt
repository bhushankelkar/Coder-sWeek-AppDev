package com.example.menuapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import kotlinx.android.synthetic.main.activity_firebase_auth.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class HomePage : AppCompatActivity() {
    lateinit var providers : List<AuthUI.IdpConfig>

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
        providers = Arrays.asList<AuthUI.IdpConfig>(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )

        button2.setOnClickListener {
            AuthUI.getInstance().signOut(this@HomePage)
                .addOnCompleteListener {
                    btn_sign_out.isEnabled=false
                    showSignInOptions()
                }
                .addOnFailureListener {
                        e-> Toast.makeText(this@HomePage,e.message, Toast.LENGTH_SHORT).show()
                }
        }

    }
    private val MY_REQUEST_CODE: Int = 7117
    private fun showSignInOptions() {
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).setTheme(R.style.MyTheme).build(),MY_REQUEST_CODE)
    }

}
