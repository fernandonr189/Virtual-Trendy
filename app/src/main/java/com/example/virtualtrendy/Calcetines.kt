package com.example.virtualtrendy

class Calcetines(
    idPrenda: Int,
    descripcion: String,
    precio: Double,
    talla: String,
    color: String,
    var tipo: String,
    var longitud: String,
    var material: String,
    var estampado: Boolean
) : Prenda(idPrenda, descripcion, precio, talla, color) {

    override fun toString() : String {
        val pantsString : String =   idPrenda.toString() + "\n" +
                descripcion + "\n" +
                precio.toString() + "\n" +
                talla.toString() + "\n" +
                color.toString() + "\n" +
                tipo + "\n" +
                longitud + "\n" +
                material + "\n" +
                estampado + "\n" +
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
        tipo = userData[5]
        longitud = userData[6]
        material = userData[7]
        estampado = userData[8] == "true"
    }
}