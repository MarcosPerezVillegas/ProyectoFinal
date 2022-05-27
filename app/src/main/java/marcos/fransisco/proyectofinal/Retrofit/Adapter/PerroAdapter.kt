package marcos.fransisco.proyectofinal.Retrofit.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import marcos.fransisco.proyectofinal.R
import marcos.fransisco.proyectofinal.Retrofit.ViewHolder.PerroViewHolder


class PerroAdapter (val imagenes:List<String>): RecyclerView.Adapter<PerroViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerroViewHolder {
            val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
            return PerroViewHolder(layoutInflater.inflate(R.layout.item_perro,parent,false))
        }

    override fun onBindViewHolder(holder: PerroViewHolder, position: Int) {
        val item:String = imagenes[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = imagenes.size

}
