package marcos.fransisco.proyectofinal.juego

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import marcos.fransisco.proyectofinal.R
import kotlin.random.Random

var respuestaAcertada = false
var numAleatorio:Int = 0

class AdivinarFragment : Fragment() {
    lateinit var etRespuesta: EditText
    lateinit var btnVerificar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_adivinar, container, false)

        fun generaNumero(){
            numAleatorio = Random.nextInt(1,5)
            etRespuesta.text.clear()
        }

        fun initUi(){
            etRespuesta = vista.findViewById(R.id.etRespuesta)
            btnVerificar = vista.findViewById(R.id.btnVerificar)
            generaNumero()
        }

        initUi()

        btnVerificar.setOnClickListener{
            val strRespuesta =etRespuesta.text.toString()
            if(strRespuesta.equals("")){
                Toast.makeText(requireContext(),"Dejaste el campo vacío", Toast.LENGTH_LONG).show()
            }else{
                generaNumero()
                respuestaAcertada = numAleatorio  == strRespuesta.toInt()
                findNavController().navigate(R.id.action_adivinarFragment_to_resultadoJuegoFragment)
            }
        }
        return vista
    }
}