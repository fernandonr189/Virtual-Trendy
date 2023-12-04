package com.example.virtualtrendy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.virtualtrendy.Calcetines
import com.example.virtualtrendy.Pantalon
import com.example.virtualtrendy.Playera
import com.example.virtualtrendy.Prenda
import com.example.virtualtrendy.PrendaAdapter
import com.example.virtualtrendy.R
import com.example.virtualtrendy.Zapatos

class Productos : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var prendaAdapter: PrendaAdapter

    private lateinit var productos: Array<Prenda>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        val playera1 = Playera(1, "Playera de algodón", 15.99, "M", "Blanco", "Algodón", true, "Corta", "Redondo", "Verano")
        val playera2 = Playera(2, "Playera deportiva", 20.00, "L", "Negro", "Poliéster", false, "Larga", "V", "Invierno")

        // Creando objetos de la clase Pantalon
        val pantalon1 = Pantalon(3, "Jeans clásico", 25.99, "32", "Azul", "Denim", "Recto", "Unisex", "Botones", "Todas")
        val pantalon2 = Pantalon(4, "Pantalón chino", 30.00, "34", "Beige", "Algodón", "Slim", "Masculino", "Cremallera", "Verano")

        // Creando objetos de la clase Zapatos
        val zapatos1 = Zapatos(5, "Zapatos de cuero", 50.00, "42", "Marrón", "Clarks", "Cordones", "Cuero")
        val zapatos2 = Zapatos(6, "Tenis deportivos", 60.00, "40", "Blanco", "Nike", "Velcro", "Sintético")

        // Creando objetos de la clase Calcetines
        val calcetines1 = Calcetines(7, "Calcetines de algodón", 5.99, "M", "Negro", "Deportivos", "Corto", "Algodón", true)
        val calcetines2 = Calcetines(8, "Calcetines térmicos", 6.99, "L", "Gris", "Térmicos", "Largo", "Lana", false)

        // Almacenando todos los objetos en un mismo arreglo
        val productos = arrayOf<Prenda>(playera1, playera2, pantalon1, pantalon2, zapatos1, zapatos2, calcetines1, calcetines2)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        prendaAdapter = PrendaAdapter(productos) // Asegúrate de que 'productos' esté accesible aquí
        recyclerView.adapter = prendaAdapter
    }
}