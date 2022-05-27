package marcos.fransisco.proyectofinal.volley

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import marcos.fransisco.proyectofinal.R
import marcos.fransisco.proyectofinal.volley.adaptador.PersonajeAdapter
import marcos.fransisco.proyectofinal.volley.modelo.Personaje

class VolleyFragment : Fragment() {
    lateinit var myRecycler: RecyclerView
    lateinit var adaptador: PersonajeAdapter
    lateinit var listaPersonajes:ArrayList<Personaje>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_volley, container, false)

        listaPersonajes = ArrayList<Personaje>()
        myRecycler = vista.findViewById(R.id.rvPersonajes)
        adaptador = PersonajeAdapter(listaPersonajes)
        myRecycler.adapter = adaptador
        getPersonajes()
        myRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

        return vista
    }
    fun getPersonajes(){
        val queue = Volley.newRequestQueue(requireContext())
        val url = "https://rickandmortyapi.com/api/character"

        val objectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,
            { respuesta ->
                //object si es un array meter directo
                val personajesJson = respuesta.getJSONArray("results")
                for (indice in 0..personajesJson.length()-1){
                    val personajeIndJson = personajesJson.getJSONObject(indice)
                    val personaje = Personaje(personajeIndJson.getString("name"),personajeIndJson.getString("image"))
                    listaPersonajes.add(personaje)
                }
                adaptador.notifyDataSetChanged()
            },
            {
                Log.e("PersonajesApi","Error")
            })
        queue.add(objectRequest)
    }
}