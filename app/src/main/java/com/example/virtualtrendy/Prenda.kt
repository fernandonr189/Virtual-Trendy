package com.example.virtualtrendy

class Prenda(
    var idPrenda: Int,
    var descripcion: String,
    var precio: Double,
    var talla: String,
    var color: String
) {
    fun getIdPrenda(): Int {
        return idPrenda
    }

    fun setIdPrenda(idPrenda: Int) {
        this.idPrenda = idPrenda
    }

    fun getDescripcion(): String {
        return descripcion
    }

    fun setDescripcion(descripcion: String) {
        this.descripcion = descripcion
    }

    fun getPrecio(): Double {
        return precio
    }

    fun setPrecio(precio: Double) {
        this.precio = precio
    }

    fun getTalla(): String {
        return talla
    }

    fun setTalla(talla: String) {
        this.talla = talla
    }

    fun getColor(): String {
        return color
    }

    fun setColor(color: String) {
        this.color = color
    }
}