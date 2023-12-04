package com.example.virtualtrendy

class Zapatos(
    idPrenda: Int,
    descripcion: String,
    precio: Double,
    talla: String,
    color: String,
    var marca: String,
    var tipoCierre: String,
    var material: String
) : Prenda(idPrenda, descripcion, precio, talla, color) {

    override fun toString() : String {
        val pantsString : String =   idPrenda.toString() + "\n" +
                descripcion + "\n" +
                precio.toString() + "\n" +
                talla.toString() + "\n" +
                color.toString() + "\n" +
                marca + "\n" +
                tipoCierre + "\n" +
                material + "\n" +
                "\\"
        return pantsString
    }

    public fun fromString(data : String) {
        val userData = data.split("\n")
        idPrenda = userData[0].toInt()
        descripcion = userData[1]
        precio = userData[2].toDouble()
        talla = userData[3]
        color = userData[4]
        marca = userData[5]
        tipoCierre = userData[6]
        material = userData[7]
    }
}