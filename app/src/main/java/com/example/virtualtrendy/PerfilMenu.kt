package com.example.virtualtrendy

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class PerfilMenu : AppCompatActivity() {

    private lateinit var logged_user: User

    private lateinit var nombreText: TextView
    private lateinit var direccionText: TextView
    private lateinit var correoText: TextView
    private lateinit var telefonoText: TextView
    private lateinit var contraseñaText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_menu)

        nombreText = findViewById(R.id.nombreText)
        direccionText = findViewById(R.id.direccionText)
        correoText = findViewById(R.id.correoText)
        telefonoText = findViewById(R.id.telefonoText)
        contraseñaText = findViewById(R.id.contraseñaText)

        logged_user = getUser()

        nombreText.text = logged_user.userName
        direccionText.text = logged_user.address
        nombreText.text = logged_user.userEmail
        telefonoText.text = logged_user.userPhone
        contraseñaText.text = logged_user.password

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
}