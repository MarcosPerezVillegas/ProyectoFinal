package com.example.proyectoprueba

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.R
import androidx.navigation.fragment.findNavController
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [tablasPracticarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
var respuestaCorrecta= false
class tablasPracticarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var trespuesta: EditText
    lateinit var tfactor1: TextView
    lateinit var tfactor2: TextView
    lateinit var btnComprobar: Button
    var factor1: Int = 0
    var factor2: Int = 0
    var respuesta: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vistaPracticarTablas = inflater.inflate(R.layout.fragment_tablas_practicar, container, false)
        fun multi(){
            factor1 = Random.nextInt(0,10)
            factor2 = Random.nextInt(0,10)
            respuesta = factor1*factor2
        }
        fun initUI(){
            tfactor1 = vistaPracticarTablas.findViewById(R.id.factor1)
            tfactor2 = vistaPracticarTablas.findViewById(R.id.factor2)
            trespuesta = vistaPracticarTablas.findViewById(R.id.respuesta)
            btnComprobar = vistaPracticarTablas.findViewById(R.id.btnComprobar)
            multi()
            tfactor1.text = "$factor1"
            tfactor2.text = "$factor2"

        }
        initUI()
        btnComprobar.setOnClickListener {
            var strRespuesta = trespuesta.text.toString()
            if(strRespuesta.equals("")){
                initUI()
            }
            else{
                if (respuesta==strRespuesta.toInt()){
                    respuestaCorrecta=true
                    trespuesta.text.clear()
                }
                else{
                    respuestaCorrecta=false
                }
                findNavController().navigate(R.id.accion_tablasPracticar_respuestaTablas)
            }
        }
        return vistaPracticarTablas
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment tablasPracticarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            tablasPracticarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}