package com.example.virtualtrendy

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var loginButton : Button
    private lateinit var registerButton : Button
    private lateinit var usernameTextField : TextInputEditText
    private lateinit var passwordTextField : TextInputEditText
    private lateinit var usersList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usersList = getUsers()
        loginButton = findViewById(R.id.login_button)
        registerButton = findViewById(R.id.register_button)
        usernameTextField = findViewById(R.id.username_textfield)
        passwordTextField = findViewById(R.id.password_textfield)
        loginButton.setOnClickListener { 
            if(validateForm()) {
                login()
            }
            else {
                Toast.makeText(this, "Por favor, introduzca sus datos", Toast.LENGTH_SHORT).show()
            }
        }
        registerButton.setOnClickListener {
            goToRegisterForm()
        }
    }


    fun getUsers() : ArrayList<User>{
        val sharedPref = getSharedPreferences("USUARIOS", Context.MODE_PRIVATE)
        val usersString = sharedPref.getString("USERS", "EMPTY")
        if(usersString.contentEquals("EMPTY")) {
            Toast.makeText(this, "No hay usuarios registrados", Toast.LENGTH_SHORT).show()
            return ArrayList<User>()
        }
        val newUsersList : ArrayList<User> = ArrayList<User>()
        val users = usersString?.split("\\")
        if (users != null) {
            for(user in users) {
                if(user.isNotEmpty()) {
                    val newUser = User(1, "","", "", "", "")
                    newUser.fromString(user)
                    newUsersList.add(newUser)
                }
            }
        }
        return newUsersList
    }

    private fun goToRegisterForm() {
        val intent = Intent(this, RegisterForm::class.java).apply {

        }
        startActivity(intent)
    }

    private fun login() {
        for(user in this.usersList) {
            if(usernameTextField.text.toString() == user.userEmail) {
                if(passwordTextField.text.toString() == user.password) {
                    Toast.makeText(this, "Login correcto", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateForm() : Boolean {
        return !(usernameTextField.text.isNullOrEmpty() || passwordTextField.text.isNullOrEmpty())
    }
}