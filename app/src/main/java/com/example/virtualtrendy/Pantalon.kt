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
    fun getTipoTejidos(): String {
        return tipoTejidos
    }

    fun setTipoTejidos(tipoTejidos: String) {
        this.tipoTejidos = tipoTejidos
    }

    fun getEstilo(): String {
        return estilo
    }

    fun setEstilo(estilo: String) {
        this.estilo = estilo
    }

    fun getGenero(): String {
        return genero
    }

    fun setGenero(genero: String) {
        this.genero = genero
    }

    fun getCierre(): String {
        return cierre
    }

    fun setCierre(cierre: String) {
        this.cierre = cierre
    }

    fun getTemporada(): String {
        return temporada
    }

    fun setTemporada(temporada: String) {
        this.temporada = temporada
    }
}