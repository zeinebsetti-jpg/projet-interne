package com.example.minishopmanager

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUserName = findViewById<EditText>(R.id.etUserName)
        val cbRemember = findViewById<CheckBox>(R.id.cbRemember)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Accéder aux préférences
        prefs = getSharedPreferences("MiniShopPrefs", MODE_PRIVATE)

        // Récupérer les informations sauvegardées
        etUserName.setText(prefs.getString("USERNAME", ""))
        cbRemember.isChecked = prefs.getBoolean("REMEMBER", false)

        btnLogin.setOnClickListener {

            val username = etUserName.text.toString().trim()

            if (username.isEmpty()) {
                Toast.makeText(
                    this,
                    "Veuillez saisir votre nom",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val editor = prefs.edit()

            if (cbRemember.isChecked) {
                editor.putString("USERNAME", username)
                editor.putBoolean("REMEMBER", true)
            } else {
                editor.clear()
            }

            editor.apply()

            Toast.makeText(
                this,
                "Bienvenue $username",
                Toast.LENGTH_SHORT
            ).show()

            // Ouvrir le catalogue
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}