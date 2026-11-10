package com.example.minishopmanager

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)

        val listView = findViewById<ListView>(
            R.id.listViewProducts
        )

        // Charger les produits depuis JSON
        val products = lireProduitsDepuisJSON()

        // Créer la base de données
        val dbHelper = DBHelper(this)

        // Créer l'adaptateur
        val adapter = ProductAdapter(
            this,
            products
        ) { product ->

            val resultat = dbHelper.ajouterProduit(product)

            if (resultat != -1L) {
                Toast.makeText(
                    this,
                    "${product.nom} ajouté au panier !",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Erreur lors de l'ajout",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Afficher la liste
        listView.adapter = adapter

        // Ajouter aussi un produit en cliquant sur sa ligne
        listView.setOnItemClickListener { _, _, position, _ ->

            val product = products[position]

            val resultat = dbHelper.ajouterProduit(product)

            if (resultat != -1L) {
                Toast.makeText(
                    this,
                    "${product.nom} ajouté au panier !",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    // Fonction pour lire les produits JSON
    private fun lireProduitsDepuisJSON(): ArrayList<Product> {

        val products = ArrayList<Product>()

        try {
            val inputStream = assets.open("produits.json")

            val jsonString = inputStream.bufferedReader().use {
                it.readText()
            }

            val jsonObject = JSONObject(jsonString)

            val jsonArray = jsonObject.getJSONArray("produits")

            for (i in 0 until jsonArray.length()) {

                val item = jsonArray.getJSONObject(i)

                val nom = item.getString("nom")
                val image = item.getString("image")

                products.add(
                    Product(nom, image)
                )
            }

        } catch (e: Exception) {

            Toast.makeText(
                this,
                "Erreur de lecture JSON : ${e.message}",
                Toast.LENGTH_LONG
            ).show()
        }

        return products
    }
}