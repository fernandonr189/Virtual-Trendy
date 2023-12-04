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

    fun getManga(): String {
        return manga
    }

    fun setManga(manga: String) {
        this.manga = manga
    }

    fun getTipoCuello(): String {
        return tipoCuello
    }

    fun setTipoCuello(tipoCuello: String) {
        this.tipoCuello = tipoCuello
    }

    fun getTemporada(): String {
        return temporada
    }

    fun setTemporada(temporada: String) {
        this.temporada = temporada
    }
}