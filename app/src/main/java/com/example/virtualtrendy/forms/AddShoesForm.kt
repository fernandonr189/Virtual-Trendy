package com.example.virtualtrendy.forms

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.virtualtrendy.Pantalon
import com.example.virtualtrendy.R
import com.example.virtualtrendy.Zapatos
import com.google.android.material.textfield.TextInputEditText

class AddShoesForm : AppCompatActivity() {

    private lateinit var descriptionTextField : TextInputEditText
    private lateinit var precioTextField : TextInputEditText
    private lateinit var tallaTextField : TextInputEditText
    private lateinit var colorTextField : TextInputEditText
    private lateinit var marcaTextField : TextInputEditText
    private lateinit var cierreTextField : TextInputEditText
    private lateinit var materialTextField: TextInputEditText
    private lateinit var sumbitButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_shoes_form)

        descriptionTextField = findViewById(R.id.description_shoes)
        precioTextField = findViewById(R.id.precio_shoes)
        tallaTextField = findViewById(R.id.talla_shoes)
        colorTextField = findViewById(R.id.color_shoes)
        marcaTextField = findViewById(R.id.marca_shoes)
        cierreTextField = findViewById(R.id.tipo_cierre_shoes)
        materialTextField = findViewById(R.id.material_shoes)

        sumbitButton = findViewById(R.id.submit_shoes_button)

        sumbitButton.setOnClickListener {
            if(validateForm()) {
                createShoes()
            }
            else {
                Toast.makeText(this, "Complete el formulario", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateForm() : Boolean {
        return !(descriptionTextField.text.isNullOrEmpty() ||
                precioTextField.text.isNullOrEmpty() ||
                tallaTextField.text.isNullOrEmpty() ||
                colorTextField.text.isNullOrEmpty() ||
                marcaTextField.text.isNullOrEmpty() ||
                cierreTextField.text.isNullOrEmpty() ||
                materialTextField.text.isNullOrEmpty())
    }

    private fun createShoes() {
        val shoes = Zapatos((0..9000).random(),
            descripcion = descriptionTextField.text.toString(),
            precio = precioTextField.text.toString().toDouble(),
            talla = tallaTextField.text.toString(),
            color = colorTextField.text.toString(),
            marca = marcaTextField.text.toString(),
            tipoCierre = cierreTextField.text.toString(),
            material = materialTextField.text.toString())

        val sharedPref = getSharedPreferences("ZAPATOS", Context.MODE_PRIVATE)
        val shoesString = sharedPref.getString("ZAPATOS", "EMPTY")
        var finalShoesString = ""
        finalShoesString = if(shoesString.contentEquals("EMPTY")){
            shoes.toString()
        }else {
            shoesString + shoes.toString()
        }
        val editor = sharedPref.edit()
        editor.putString("ZAPATOS", finalShoesString)
        editor.apply()
        finish()
    }
}