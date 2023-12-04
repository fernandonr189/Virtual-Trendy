package com.example.virtualtrendy.forms

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.example.virtualtrendy.Calcetines
import com.example.virtualtrendy.R
import com.google.android.material.textfield.TextInputEditText

class AddSocksForm : AppCompatActivity() {
    
    private lateinit var descriptionTextField : TextInputEditText
    private lateinit var precioTextField : TextInputEditText
    private lateinit var tallaTextField : TextInputEditText
    private lateinit var colorTextField : TextInputEditText
    private lateinit var tipoTextField : TextInputEditText
    private lateinit var longitudTextField : TextInputEditText
    private lateinit var materialTextField : TextInputEditText
    private lateinit var estampadoCheckBox: CheckBox
    private lateinit var submitButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_add_socks)
        
        descriptionTextField = findViewById(R.id.description_socks)
        precioTextField = findViewById(R.id.precio_socks)
        tallaTextField = findViewById(R.id.talla_socks)
        colorTextField = findViewById(R.id.color_socks)
        tipoTextField = findViewById(R.id.tipo_socks)
        longitudTextField = findViewById(R.id.longitud_socks)
        materialTextField = findViewById(R.id.material_socks)
        estampadoCheckBox = findViewById(R.id.estampado_socks)
        submitButton = findViewById(R.id.submit_pants_button)
        
        submitButton.setOnClickListener {
            if(validateForm()) {
                createSock()
            }
            else {
                Toast.makeText(this, "Complete el formulario", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun validateForm() : Boolean{
        return !(descriptionTextField.text.isNullOrEmpty() ||
                precioTextField.text.isNullOrEmpty() ||
                tallaTextField.text.isNullOrEmpty() ||
                colorTextField.text.isNullOrEmpty() ||
                tipoTextField.text.isNullOrEmpty() ||
                longitudTextField.text.isNullOrEmpty() ||
                materialTextField.text.isNullOrEmpty())
    }
    
    private fun createSock() {
        val sock = Calcetines((0..9000).random(),
            descripcion = descriptionTextField.text.toString(),
            precio = precioTextField.text.toString().toDouble(),
            talla = tallaTextField.text.toString(),
            color = colorTextField.text.toString(),
            tipo = tipoTextField.text.toString(),
            longitud = longitudTextField.text.toString(),
            material = materialTextField.text.toString(),
            estampado = estampadoCheckBox.isChecked)

        val sharedPref = getSharedPreferences("CALCETINES", Context.MODE_PRIVATE)
        val sockString = sharedPref.getString("CALCETINES", "EMPTY")
        var finalSockScreen = ""
        finalSockScreen = if(sockString.contentEquals("EMPTY")){
            sock.toString()
        }else {
            sockString + sock.toString()
        }
        val editor = sharedPref.edit()
        editor.putString("CALCETINES", finalSockScreen)
        editor.apply()
        finish()
    }
}