package com.example.disenoproyecto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.virtualtrendy.R

class ProductoAdapter(private val productos: List<Producto>) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        // Aquí puedes inicializar los elementos de la UI de cada ítem, por ejemplo, un TextView para el nombre del producto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }


    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.view.findViewById<TextView>(R.id.textViewNombreProducto).text = producto.nombre
        holder.view.findViewById<TextView>(R.id.textViewPrecioProducto).text = "$${producto.precio}"
        // Configura la imagen del producto aquí, por ejemplo:
        holder.view.findViewById<ImageView>(R.id.imageViewProducto).setImageResource(R.drawable.ic_launcher_foreground)
    }



    override fun getItemCount() = productos.size
}
