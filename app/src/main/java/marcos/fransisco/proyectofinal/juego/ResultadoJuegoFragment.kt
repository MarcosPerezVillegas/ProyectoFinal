package marcos.fransisco.proyectofinal.juego

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import marcos.fransisco.proyectofinal.R


class ResultadoJuegoFragment : Fragment() {
    lateinit var animView: LottieAnimationView
    lateinit var btnRegresar: Button
    lateinit var tvRespuestaCorrecta: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_resultado_juego, container, false)

        fun initUi(){
            animView = vista.findViewById(R.id.animation_view)
            btnRegresar = vista.findViewById(R.id.btnRegresar)
            tvRespuestaCorrecta = vista.findViewById(R.id.tvRespuestaCorrecta)
        }

        initUi()

        var sonidoCorrecto = MediaPlayer.create(requireContext(), R.raw.correcto)
        var sonidoIncorrecto = MediaPlayer.create(requireContext(),R.raw.incorrecto)

        btnRegresar.setOnClickListener{
            findNavController().navigate(R.id.action_resultadoJuegoFragment_to_adivinarFragment)
        }

        if(respuestaAcertada){
            animView.setAnimation(R.raw.success)
            sonidoCorrecto.start()
        }else{
            animView.setAnimation(R.raw.wrong)
            sonidoIncorrecto.start()
        }

        tvRespuestaCorrecta.text = numAleatorio.toString()

        return vista
    }
}