package com.example.virtualtrendy

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast

class StartScreen : AppCompatActivity() {

    private lateinit var welcomeText : TextView
    private lateinit var logged_user : User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        logged_user = getUser()
        welcomeText = findViewById(R.id.welcome_text)
        welcomeText.setText("Bienvenido " + logged_user.userName)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    private fun getUser() : User {
        val sharedPref = getSharedPreferences("USUARIO", Context.MODE_PRIVATE)
        val usersString = sharedPref.getString("USUARIO", "EMPTY")
        var user = User(1, "", "", "", "", "")
        if(usersString.contentEquals("EMPTY")) {
            Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
            return User(1, "", "", "", "", "")
        }
        if (usersString != null) {
            user.fromString(usersString)
        }
        return user
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection.
        return when (item.itemId) {
            R.id.start_menu_item -> {
                goToProductos()
                true
            }
            R.id.products_menu_item -> {
                goToProductos()
                true
            }
            R.id.cart_menu_item -> {
                goToCarrito()
                true
            }
            R.id.profile_menu_item -> {
                goToPerfil()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

    private fun goToInicio() {
        val intent = Intent(this, Productos::class.java).apply {

        }
        startActivity(intent)
    }
    private fun goToProductos() {
        val intent = Intent(this, Productos::class.java).apply {

        }
        startActivity(intent)
    }
    private fun goToCarrito() {
        val intent = Intent(this, Productos::class.java).apply {

        }
        startActivity(intent)
    }
    private fun goToPerfil() {
        val intent = Intent(this, PerfilMenu::class.java).apply {

        }
        startActivity(intent)
    }
}