package com.fadhiil2010.klinik_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignIn : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)

        val ActButton2 = findViewById<TextView>(R.id.tvSignUp)
        ActButton2.setOnClickListener {
            val Intent = Intent(this, SignUp::class.java)
            startActivity(Intent)
        }

        val ActButton1 = findViewById<Button>(R.id.btnSignIn)
        ActButton1.setOnClickListener {
            val Intent = Intent(this, Doctors::class.java)
            startActivity(Intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}