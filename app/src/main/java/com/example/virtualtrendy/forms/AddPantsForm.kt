package com.example.virtualtrendy.forms

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.example.virtualtrendy.Calcetines
import com.example.virtualtrendy.Pantalon
import com.example.virtualtrendy.R
import com.google.android.material.textfield.TextInputEditText

class AddPantsForm : AppCompatActivity() {

    private lateinit var descriptionTextField : TextInputEditText
    private lateinit var precioTextField : TextInputEditText
    private lateinit var tallaTextField : TextInputEditText
    private lateinit var colorTextField : TextInputEditText
    private lateinit var tipoTextField : TextInputEditText
    private lateinit var estiloTextField : TextInputEditText
    private lateinit var generoTextField : TextInputEditText
    private lateinit var cierreTextField: TextInputEditText
    private lateinit var temporadaTextField : TextInputEditText
    private lateinit var sumbitButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pants_form)

        descriptionTextField = findViewById(R.id.description_pants)
        precioTextField = findViewById(R.id.precio_pants)
        tallaTextField = findViewById(R.id.talla_pants)
        colorTextField = findViewById(R.id.color_pants)
        tipoTextField = findViewById(R.id.tipo_pants)
        estiloTextField = findViewById(R.id.estilo_pants)
        generoTextField = findViewById(R.id.genero_pants)
        cierreTextField = findViewById(R.id.cierre_pants)
        temporadaTextField = findViewById(R.id.temporada_pants)
        sumbitButton = findViewById(R.id.submit_pants_button)

        sumbitButton.setOnClickListener {
            if(validateForm()) {
                createPants()
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
                tipoTextField.text.isNullOrEmpty() ||
                estiloTextField.text.isNullOrEmpty() ||
                generoTextField.text.isNullOrEmpty() ||
                cierreTextField.text.isNullOrEmpty() ||
                temporadaTextField.text.isNullOrEmpty())
    }

    private fun createPants() {
        val pants = Pantalon((0..9000).random(),
            descripcion = descriptionTextField.text.toString(),
            precio = precioTextField.text.toString().toDouble(),
            talla = tallaTextField.text.toString(),
            color = colorTextField.text.toString(),
            tipoTejidos = tipoTextField.text.toString(),
            estilo = estiloTextField.text.toString(),
            genero = generoTextField.text.toString(),
            cierre = cierreTextField.text.toString(),
            temporada = temporadaTextField.text.toString())

        val sharedPref = getSharedPreferences("PANTALONES", Context.MODE_PRIVATE)
        val pantsString = sharedPref.getString("PANTALONES", "EMPTY")
        var finalPantsString = ""
        finalPantsString = if(pantsString.contentEquals("EMPTY")){
            pants.toString()
        }else {
            pantsString + pants.toString()
        }
        val editor = sharedPref.edit()
        editor.putString("PANTALONES", finalPantsString)
        editor.apply()
        finish()
    }
}