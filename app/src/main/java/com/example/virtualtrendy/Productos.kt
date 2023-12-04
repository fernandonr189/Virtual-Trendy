package com.example.virtualtrendy

import android.content.Context
import android.os.Bundle
import android.widget.Toast
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

    private lateinit var productos: ArrayList<Prenda>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
        productos = getPrendas()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        prendaAdapter = PrendaAdapter(productos) // Asegúrate de que 'productos' esté accesible aquí
        recyclerView.adapter = prendaAdapter
    }

    private fun getPrendas() : ArrayList<Prenda> {
        var _prendas = ArrayList<Prenda>()
        var sharedPref = getSharedPreferences("CALCETINES", Context.MODE_PRIVATE)
        var socksString = sharedPref.getString("CALCETINES", "EMPTY")
        if(socksString == "EMPTY") {
            Toast.makeText(this, "No hay calcetines", Toast.LENGTH_SHORT).show()
        }
        else {
            var _calcetines = socksString?.split("\\")
            if (_calcetines != null) {
                for(calcetin in _calcetines) {
                    if(calcetin.isNotEmpty()) {
                        var nuevoCalcetin = Calcetines(1, "", 1.0, "", "", "", "", "", false)
                        nuevoCalcetin.fromString(calcetin)
                        _prendas.add(nuevoCalcetin)
                    }
                }
            }
        }
        sharedPref = getSharedPreferences("PANTALONES", Context.MODE_PRIVATE)
        socksString = sharedPref.getString("PANTALONES", "EMPTY")
        if(socksString == "EMPTY") {
            Toast.makeText(this, "No hay pantalones", Toast.LENGTH_SHORT).show()
        }
        else {
            var _pantalones = socksString?.split("\\")
            if (_pantalones != null) {
                for(pantalon in _pantalones) {
                    if(pantalon.isNotEmpty()) {
                        var nuevoPantalon = Pantalon(1, "", 1.1, "", "", "", "", "", "", "")
                        nuevoPantalon.fromString(pantalon)
                        _prendas.add(nuevoPantalon)
                    }
                }
            }
        }
        sharedPref = getSharedPreferences("PLAYERAS", Context.MODE_PRIVATE)
        socksString = sharedPref.getString("PLAYERAS", "EMPTY")
        if(socksString == "EMPTY") {
            Toast.makeText(this, "No hay playeras", Toast.LENGTH_SHORT).show()
        }
        else {
            var _playeras = socksString?.split("\\")
            if (_playeras != null) {
                for(playera in _playeras) {
                    if(playera.isNotEmpty()) {
                        var nuevaPlayera = Playera(1, "", 1.1, "", "", "", false, "", "", "")
                        nuevaPlayera.fromString(playera)
                        _prendas.add(nuevaPlayera)
                    }
                }
            }
        }
        sharedPref = getSharedPreferences("ZAPATOS", Context.MODE_PRIVATE)
        socksString = sharedPref.getString("ZAPATOS", "EMPTY")
        if(socksString == "EMPTY") {
            Toast.makeText(this, "No hay zapatos", Toast.LENGTH_SHORT).show()
        }
        else {
            var _zapatos = socksString?.split("\\")
            if (_zapatos != null) {
                for(zapato in _zapatos) {
                    if(zapato.isNotEmpty()) {
                        var nuevoZapato = Zapatos(1, "", 1.0, "", "", "", "", "")
                        nuevoZapato.fromString(zapato)
                        _prendas.add(nuevoZapato)
                    }
                }
            }
        }
        return _prendas
    }
}