package marcos.fransisco.proyectofinal.Retrofit

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import marcos.fransisco.proyectofinal.R
import marcos.fransisco.proyectofinal.Retrofit.Adapter.PerroAdapter
import marcos.fransisco.proyectofinal.Retrofit.Class.APIServicio
import marcos.fransisco.proyectofinal.Retrofit.Class.ClassPerro
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitFragment : Fragment(), SearchView.OnQueryTextListener {
    lateinit var adapter: PerroAdapter
    lateinit var searchView: SearchView
    lateinit var recyclerPerro: RecyclerView
    private val imagenesPerros = mutableListOf<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_retrofit, container, false)
        searchView= vista.findViewById(R.id.svPerro)
        searchView.setOnQueryTextListener(this)
        recyclerPerro=vista.findViewById(R.id.rvPerro)
        initRecyclerView()
        return vista
    }

    private fun initRecyclerView() {
        adapter = PerroAdapter(imagenesPerros)
        recyclerPerro.layoutManager=LinearLayoutManager(requireContext())
        recyclerPerro.adapter=adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buscarXNombre(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<ClassPerro> = getRetrofit().create(APIServicio::class.java).getPerrosXRaza("$query/images")
            val Perros:ClassPerro?=call.body()
            requireActivity().runOnUiThread{
                if(call.isSuccessful){
                    val imagenes:List<String> = Perros?.imagenes ?: emptyList()
                    imagenesPerros.clear()
                    imagenesPerros.addAll(imagenes)
                    adapter.notifyDataSetChanged()
                }
                else{
                    showError()
                }
                //
            }
        }

    }


    private fun showError() {
        Toast.makeText(requireContext(),"Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            buscarXNombre(query.toLowerCase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

}