package com.example.minishopmanager

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "minishop.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("""
            CREATE TABLE panier (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT NOT NULL,
                image TEXT
            )
        """)
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS panier")
        onCreate(db)
    }

    fun ajouterProduit(product: Product): Long {

        val db = writableDatabase

        val values = ContentValues().apply {
            put("nom", product.nom)
            put("image", product.image)
        }

        val resultat = db.insert("panier", null, values)


        return resultat
    }
}