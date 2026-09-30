package com.example.minishopmanager

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)

        // Récupérer le ListView
        val listView = findViewById<ListView>(
            R.id.listViewProducts
        )

        // Récupérer les produits
        val products = resources.getStringArray(
            R.array.products
        )

        // Photos correspondant aux produits
        val images = arrayOf(
            R.drawable.telephone,
            R.drawable.casque,
            R.drawable.montre,
            R.drawable.chargeur,
            R.drawable.colier,
            R.drawable.bracelet,


        )

        // Créer l'adaptateur personnalisé
        val adapter = ProductAdapter(
            this,
            products,
            images
        )

        // Afficher les produits
        listView.adapter = adapter
    }
}