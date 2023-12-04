package com.example.virtualtrendy

class Pantalon(
    idPrenda: Int,
    descripcion: String,
    precio: Double,
    talla: String,
    color: String,
    var tipoTejidos: String,
    var estilo: String,
    var genero: String,
    var cierre: String,
    var temporada: String
) : Prenda(idPrenda, descripcion, precio, talla, color) {

    override fun toString() : String {
        val pantsString : String =   idPrenda.toString() + "\n" +
                                    descripcion + "\n" +
                                    precio.toString() + "\n" +
                                    talla.toString() + "\n" +
                                    color.toString() + "\n" +
                                    tipoTejidos + "\n" +
                                    estilo + "\n" +
                                    genero + "\n" +
                                    cierre + "\n" +
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
        tipoTejidos = userData[5]
        estilo = userData[6]
        genero = userData[7]
        cierre = userData[8]
        temporada = userData[9]
    }
}