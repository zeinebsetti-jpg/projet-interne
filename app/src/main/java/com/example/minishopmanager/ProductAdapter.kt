package com.example.minishopmanager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ProductAdapter(
    private val context: Context,
    private val products: Array<String>,
    private val images: Array<Int>
) : ArrayAdapter<String>(context, R.layout.item_product, products) {

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_product, parent, false)

        val imageProduct = view.findViewById<ImageView>(
            R.id.imageProduct
        )

        val textProduct = view.findViewById<TextView>(
            R.id.textProduct
        )

        val btnBuy = view.findViewById<Button>(
            R.id.btnBuy
        )

        // Nom du produit
        textProduct.text = products[position]

        // Photo du produit
        imageProduct.setImageResource(images[position])

        // Bouton Acheter
        btnBuy.setOnClickListener {

            Toast.makeText(
                context,
                "${products[position]} ajouté au panier !",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view
    }
}