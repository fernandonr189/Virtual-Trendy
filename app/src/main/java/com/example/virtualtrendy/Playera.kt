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
}