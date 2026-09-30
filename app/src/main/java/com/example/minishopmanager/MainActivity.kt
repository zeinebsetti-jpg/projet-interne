package com.example.minishopmanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ==============================
        // PARTIE 1 : Bouton Next
        // ==============================

        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {

            // Afficher le Toast
            Toast.makeText(
                this,
                "Bonjour zeineb setti !",
                Toast.LENGTH_SHORT
            ).show()

            // Ouvrir ProfileActivity
            val intent = Intent(
                this,
                ProfileActivity::class.java
            )

            startActivity(intent)
        }


        // ==============================
        // PARTIE 2 : Liste des produits
        // ==============================

        // Récupérer le ListView
        val listView = findViewById<ListView>(
            R.id.listViewProducts
        )

        // Charger les produits depuis strings.xml
        val products = resources.getStringArray(
            R.array.products
        )

        // Créer l'ArrayAdapter
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            products
        )

        // Afficher les produits dans le ListView
        listView.adapter = adapter


        // ==============================
        // PARTIE 3 : Clic sur un produit
        // ==============================

        listView.setOnItemClickListener { parent, _, position, _ ->

            val product = parent
                .getItemAtPosition(position)
                .toString()

            Toast.makeText(
                this,
                "Produit sélectionné : $product",
                Toast.LENGTH_SHORT
            ).show()
        }


        // ==============================
        // PARTIE 4 : Cycle de vie
        // ==============================

        Log.d(
            "LIFECYCLE",
            "onCreate appelé"
        )
    }
}
