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
    private val products: ArrayList<Product>,
    private val onBuy: (Product) -> Unit
) : ArrayAdapter<Product>(
    context,
    R.layout.item_product,
    products
) {

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_product, parent, false)

        val imageProduct =
            view.findViewById<ImageView>(R.id.imageProduct)

        val textProduct =
            view.findViewById<TextView>(R.id.textProduct)

        val btnBuy =
            view.findViewById<Button>(R.id.btnBuy)

        val product = products[position]

        // Afficher le nom
        textProduct.text = product.nom

        // Récupérer automatiquement l'image depuis drawable
        val imageId = context.resources.getIdentifier(
            product.image,
            "drawable",
            context.packageName
        )

        if (imageId != 0) {
            imageProduct.setImageResource(imageId)
        } else {
            imageProduct.setImageResource(
                android.R.drawable.ic_menu_gallery
            )
        }

        // Action du bouton Acheter
        btnBuy.setOnClickListener {

            onBuy(product)

            Toast.makeText(
                context,
                "${product.nom} ajouté au panier !",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view
    }
}