package marcos.fransisco.proyectofinal.tablas


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import marcos.fransisco.proyectofinal.R
import marcos.fransisco.proyectofinal.respuestaCorrecta

class RespuestaTablasFragment : Fragment() {
    lateinit var animationView: LottieAnimationView
    lateinit var btnRegresarRe: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_respuesta_tablas, container, false)
        btnRegresarRe = vista.findViewById(R.id.btnRegresarRes)
        btnRegresarRe.setOnClickListener {
            findNavController().navigate(R.id.action_respuestaTablasFragment_to_tablasPracticarFragment)
        }

        animationView= vista.findViewById(R.id.animation_view)

        if (respuestaCorrecta){
            animationView.setAnimation(R.raw.success)
        }else{
            animationView.setAnimation(R.raw.wrong)
        }
        return vista
    }
}