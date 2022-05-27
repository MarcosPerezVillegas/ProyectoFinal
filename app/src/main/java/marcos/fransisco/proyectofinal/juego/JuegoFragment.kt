package marcos.fransisco.proyectofinal.juego

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import marcos.fransisco.proyectofinal.R


class JuegoFragment : Fragment() {
    lateinit var btnContinuar: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_juego, container, false)

        btnContinuar = vista.findViewById(R.id.btnContinuar)
        btnContinuar.setOnClickListener {
            findNavController().navigate(R.id.action_juegoFragment_to_adivinarFragment)
        }

        return vista
    }
}