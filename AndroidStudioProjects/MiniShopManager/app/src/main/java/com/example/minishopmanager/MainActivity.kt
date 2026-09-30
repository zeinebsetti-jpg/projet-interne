package com.example.minishopmanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            // Afficher le Toast
            Toast.makeText(this, "Bonjour zeineb setti  !", Toast.LENGTH_SHORT).show()

            // Ouvrir ProfileActivity
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        // Ajouter un log pour le cycle de vie
        Log.d("LIFECYCLE", "onCreate appelé")
    }
}