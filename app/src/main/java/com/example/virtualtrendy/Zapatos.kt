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
    fun getMarca(): String {
        return marca
    }

    fun setMarca(marca: String) {
        this.marca = marca
    }

    fun getTipoCierre(): String {
        return tipoCierre
    }

    fun setTipoCierre(tipoCierre: String) {
        this.tipoCierre = tipoCierre
    }

    fun getMaterial(): String {
        return material
    }

    fun setMaterial(material: String) {
        this.material = material
    }
}