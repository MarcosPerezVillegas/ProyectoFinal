package com.example.proyectoprueba


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RespuestaTablasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RespuestaTablasFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var animationView: LottieAnimationView
    lateinit var btnRegresarRe: Button
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RespuestaTablasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RespuestaTablasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}