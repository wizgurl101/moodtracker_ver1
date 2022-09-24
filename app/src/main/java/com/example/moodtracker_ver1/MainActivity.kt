package com.example.moodtracker_ver1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

private const val TAG = "MainActivity"
const val EXTRA_MESSAGE = "com.example.moodtracker_ver1_selectmood"

class MainActivity : AppCompatActivity() {
    private lateinit var userEmail: String
    private lateinit var userPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userEmail = findViewById<View?>(R.id.etEmail).toString()
        userPassword = findViewById<View?>(R.id.etPassword).toString()

        Log.i(TAG, "$userEmail;$userPassword")

        val button: Button = findViewById(R.id.bLogin)
        button.setOnClickListener {
            val intent = Intent(this, SelectMood::class.java).apply {
                putExtra(EXTRA_MESSAGE, "")
            }
            startActivity(intent)
        }
    }
}