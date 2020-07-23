package com.cursoandroid.pruebafragmentsimple

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_third.*

private const val ARG_TEXT = "com.cursoandroid.pruebafragmentsimple.mensajeTexto"

class ThirdFragment : Fragment() {
    private var textArgument: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            textArgument = it.getString(ARG_TEXT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        third_fragment_textView.text = textArgument.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(textMessage: String) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TEXT, textMessage)
                }
            }
    }
}