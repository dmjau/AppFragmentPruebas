package com.cursoandroid.pruebafragmentsimple

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fourth.*

private const val ARG_MSG4 = "com.cursoandroid.pruebafragmentsimple.MENSAJE"

class FourthFragment : Fragment() {
    //Esta variable guarda el texto que proviene del MainActivity
    private var argumentText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //Esto me permite guardar en la variable local argumentText, el mensaje que proviene del MainActivity,
            // ya que comprueba que contenga el KEY llamado ARG_MSG4
            argumentText = it.getString(ARG_MSG4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Coloco en el TextView el texto que proviene del MainActivity, y que esta guardado en la variable argumentText
        fourth_fragment_textView.text = argumentText.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(messageFromMain: String) =
            FourthFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_MSG4, messageFromMain)
                }
            }
    }
}