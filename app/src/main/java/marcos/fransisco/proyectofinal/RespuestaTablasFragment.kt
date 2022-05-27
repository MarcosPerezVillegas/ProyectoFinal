package com.example.proyectoprueba


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView

class RespuestaTablasFragment : Fragment() {
    lateinit var animationView: LottieAnimationView
    lateinit var btnRegresarRe: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vistaRespuestaTablas = inflater.inflate(R.layout.fragment_respuesta_tablas, container, false)
        btnRegresarRe = vistaRespuestaTablas.findViewById(R.id.btnRegresarRes)

        btnRegresarRe.setOnClickListener {
            findNavController().navigate(R.id.accion_respuestaTablas_tablasPracticar)
        }

        animationView= vistaRespuestaTablas.findViewById(R.id.animation_view)

        if (respuestaCorrecta){
            animationView.setAnimation(R.raw.success)
        }else{
            animationView.setAnimation(R.raw.wrong)
        }
        return vistaRespuestaTablas
    }
}