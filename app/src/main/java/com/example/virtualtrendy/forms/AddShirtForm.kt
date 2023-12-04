package com.example.virtualtrendy.forms

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.example.virtualtrendy.Pantalon
import com.example.virtualtrendy.Playera
import com.example.virtualtrendy.R
import com.google.android.material.textfield.TextInputEditText

class AddShirtForm : AppCompatActivity() {

    private lateinit var descriptionTextField : TextInputEditText
    private lateinit var precioTextField : TextInputEditText
    private lateinit var tallaTextField : TextInputEditText
    private lateinit var colorTextField : TextInputEditText
    private lateinit var materialTextField : TextInputEditText
    private lateinit var mangaTextField : TextInputEditText
    private lateinit var cuelloTextField : TextInputEditText
    private lateinit var temporadaTextField: TextInputEditText
    private lateinit var estampadoCheckBox: CheckBox
    private lateinit var submitButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_shirt_form)

        descriptionTextField = findViewById(R.id.description_shirt)
        precioTextField = findViewById(R.id.precio_shirt)
        tallaTextField = findViewById(R.id.talla_shirt)
        colorTextField = findViewById(R.id.color_shirt)
        materialTextField = findViewById(R.id.material_shirt)
        mangaTextField = findViewById(R.id.manga_shirt)
        cuelloTextField = findViewById(R.id.cuello_shirt)
        temporadaTextField = findViewById(R.id.temporada_shirt)
        estampadoCheckBox = findViewById(R.id.estampado_shirt)
        submitButton = findViewById(R.id.submit_shirt_button)

        submitButton.setOnClickListener {
            if(validateForm()) {

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
                materialTextField.text.isNullOrEmpty() ||
                cuelloTextField.text.isNullOrEmpty() ||
                temporadaTextField.text.isNullOrEmpty())
    }

    private fun createPants() {
        val shirt = Playera((0..9000).random(),
            descripcion = descriptionTextField.text.toString(),
            precio = precioTextField.text.toString().toDouble(),
            talla = tallaTextField.text.toString(),
            color = colorTextField.text.toString(),
            material = materialTextField.text.toString(),
            estampado = estampadoCheckBox.isChecked(),
            manga = mangaTextField.text.toString(),
            tipoCuello = cuelloTextField.text.toString(),
            temporada = temporadaTextField.text.toString())

        val sharedPref = getSharedPreferences("PLAYERAS", Context.MODE_PRIVATE)
        val shirtString = sharedPref.getString("PLAYERAS", "EMPTY")
        var finalShirtString = ""
        finalShirtString = if(shirtString.contentEquals("EMPTY")){
            shirt.toString()
        }else {
            shirtString + shirt.toString()
        }
        val editor = sharedPref.edit()
        editor.putString("PLAYERAS", finalShirtString)
        editor.apply()
        finish()
    }
}