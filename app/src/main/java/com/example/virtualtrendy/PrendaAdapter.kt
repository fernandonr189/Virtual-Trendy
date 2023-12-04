package com.example.virtualtrendy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PrendaAdapter(private val productos: Array<Prenda>) : RecyclerView.Adapter<PrendaAdapter.PrendaViewHolder>() {

    class PrendaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewDescripcion: TextView = itemView.findViewById(R.id.textViewDescripcion)
        // Define otros elementos de la vista aquí si es necesario
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrendaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_prenda, parent, false)
        return PrendaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PrendaViewHolder, position: Int) {
        val currentItem = productos[position]
        holder.textViewDescripcion.text = currentItem.descripcion
        // Configura los otros elementos de la vista aquí
    }

    override fun getItemCount() = productos.size
}
