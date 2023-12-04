package com.example.virtualtrendy

class Playera(
    idPrenda: Int,
    descripcion: String,
    precio: Double,
    talla: String,
    color: String,
    var material: String,
    var estampado: Boolean,
    var manga: String,
    var tipoCuello: String,
    var temporada: String
) : Prenda(idPrenda, descripcion, precio, talla, color) {

    override fun toString() : String {
        val pantsString : String =   idPrenda.toString() + "\n" +
                descripcion + "\n" +
                precio.toString() + "\n" +
                talla.toString() + "\n" +
                color.toString() + "\n" +
                material + "\n" +
                estampado + "\n" +
                manga + "\n" +
                tipoCuello + "\n" +
                temporada + "\n" +
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
        material = userData[5]
        estampado = userData[6] == "true"
        manga = userData[7]
        tipoCuello = userData[8]
        temporada = userData[9]
    }
}