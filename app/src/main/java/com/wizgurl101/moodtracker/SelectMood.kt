package com.wizgurl101.moodtracker

import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.wizgurl101.moodtracker.databinding.ActivitySelectMoodBinding
import java.time.Instant
import java.time.format.DateTimeFormatter

private const val TAG = "SelectMood"

class SelectMood : AppCompatActivity() {
    private lateinit var binding: ActivitySelectMoodBinding
    private lateinit var userId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelectMoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        userId = intent.getStringExtra(EXTRA_USERID).toString()

        val buttonMood1: Button = findViewById(R.id.bMood1)
        val buttonMood2: Button = findViewById(R.id.bMood1)
        val buttonMood3: Button = findViewById(R.id.bMood1)
        val buttonMood4: Button = findViewById(R.id.bMood1)

        buttonMood1.setOnClickListener {
            saveToFirebase(1)
        }

        buttonMood2.setOnClickListener {
            saveToFirebase(2)
        }

        buttonMood3.setOnClickListener {
            saveToFirebase(3)
        }

        buttonMood4.setOnClickListener {
            saveToFirebase(4)
        }
    }

    private fun saveToFirebase(type: Int) {
        val currentDate = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")
            .format(Instant.now())

        val data = {
            "moodType" to type
            "date" to currentDate
            "userId" to userId
        }

        val db = Firebase.firestore

        db.collection("mood").add(data)
}
}