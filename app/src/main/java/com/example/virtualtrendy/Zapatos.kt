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
}