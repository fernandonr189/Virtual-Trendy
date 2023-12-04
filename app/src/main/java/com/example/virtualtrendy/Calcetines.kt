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
}