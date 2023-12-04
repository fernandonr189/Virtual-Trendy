package com.example.virtualtrendy

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.example.virtualtrendy.forms.AddPantsForm
import com.example.virtualtrendy.forms.AddShirtForm
import com.example.virtualtrendy.forms.AddShoesForm
import com.example.virtualtrendy.forms.AddSocksForm

class AdminView : AppCompatActivity() {

    private lateinit var prendas : ArrayList<Prenda>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_view)
        setSupportActionBar(findViewById(R.id.admin_toolbar))
        prendas = getPrendas()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.admin_options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection.
        return when (item.itemId) {
            R.id.add_socks_item -> {
                val intent = Intent(this, AddSocksForm::class.java).apply {

                }
                startActivity(intent)
                true
            }
            R.id.add_pants_item -> {
                val intent = Intent(this, AddPantsForm::class.java).apply {

                }
                startActivity(intent)
                true
            }
            R.id.add_shirts_item -> {
                val intent = Intent(this, AddShirtForm::class.java).apply {

                }
                startActivity(intent)
                true
            }
            R.id.add_shoes_item -> {
                val intent = Intent(this, AddShoesForm::class.java).apply {

                }
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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