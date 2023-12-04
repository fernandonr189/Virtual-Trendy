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
}