package com.example.virtualtrendy

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class RegisterForm : AppCompatActivity() {
    
    private lateinit var userNameTextField : TextInputEditText
    private lateinit var addressTextField : TextInputEditText
    private lateinit var emailTextField : TextInputEditText
    private lateinit var phoneTextField : TextInputEditText
    private lateinit var passwordTextField : TextInputEditText
    private lateinit var registerButton : Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registry_form)
        
        userNameTextField = findViewById(R.id.username_textfield_register)
        addressTextField = findViewById(R.id.address_textfield_register)
        emailTextField = findViewById(R.id.email_textfield_register)
        phoneTextField = findViewById(R.id.phone_textfield_register)
        passwordTextField = findViewById(R.id.passwrod_texfield_register)

        registerButton = findViewById(R.id.submit_register_button)
        
        registerButton.setOnClickListener { 
            if(validateForm()) {
                createUser()
                Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun validateForm() : Boolean {
        return !(userNameTextField.text.isNullOrEmpty() ||
                addressTextField.text.isNullOrEmpty() ||
                emailTextField.text.isNullOrEmpty() ||
                phoneTextField.text.isNullOrEmpty())
    }

    private fun createUser() {
        val user = User((0..9000).random(), userName= userNameTextField.text.toString(),
            address = addressTextField.text.toString(),
            userEmail = emailTextField.text.toString(),
            userPhone = phoneTextField.text.toString(),
            password = passwordTextField.text.toString()
            )

        val sharedPref = getSharedPreferences("USUARIOS", Context.MODE_PRIVATE)
        val usersString = sharedPref.getString("USERS", "EMPTY")
        var finalUserString = ""
        finalUserString = if(usersString.contentEquals("EMPTY")){
            user.toString()
        }else {
            usersString + user.toString()
        }
        val editor = sharedPref.edit()
        editor.putString("USERS", finalUserString)
        editor.apply()
        finish()
    }
}