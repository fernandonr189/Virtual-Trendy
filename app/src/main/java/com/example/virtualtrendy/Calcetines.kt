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
    fun getTipo(): String {
        return tipo
    }

    fun setTipo(tipo: String) {
        this.tipo = tipo
    }

    fun getLongitud(): String {
        return longitud
    }

    fun setLongitud(longitud: String) {
        this.longitud = longitud
    }

    fun getMaterial(): String {
        return material
    }

    fun setMaterial(material: String) {
        this.material = material
    }

    fun getEstampado(): Boolean {
        return estampado
    }

    fun setEstampado(estampado: Boolean) {
        this.estampado = estampado
    }
}