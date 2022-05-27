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

var respuestaCorrecta= false
class tablasPracticarFragment : Fragment() {
    lateinit var trespuesta: EditText
    lateinit var tfactor1: TextView
    lateinit var tfactor2: TextView
    lateinit var btnComprobar: Button
    var factor1: Int = 0
    var factor2: Int = 0
    var respuesta: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vistaPracticarTablas = inflater.inflate(R.layout., container, false)
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
}