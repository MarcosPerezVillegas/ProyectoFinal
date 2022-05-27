package marcos.fransisco.proyectofinal.Retrofit.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import marcos.fransisco.proyectofinal.databinding.ItemPerroBinding

class PerroViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemPerroBinding.bind(view)

    fun bind (imagen:String){
        Picasso.get().load(imagen).into(binding.ivPerro)
    }
}