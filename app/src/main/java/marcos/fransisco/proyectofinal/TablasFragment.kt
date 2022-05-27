package com.example.proyectoprueba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import marcos.fransisco.proyectofinal.R


class TablasFragment : Fragment() {
    lateinit var btnPracticar : Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vistaFragmentoTablas = inflater.inflate(R.layout.fragment_tablas, container, false)
        btnPracticar=vistaFragmentoTablas.findViewById(R.id.btnIrPracticar)
        btnPracticar.setOnClickListener {
            findNavController().navigate(R.id.accion_Tablas_TablasPracticar)
        }
        return vistaFragmentoTablas
    }
}