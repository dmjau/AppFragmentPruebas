package com.cursoandroid.pruebafragmentsimple

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val MSG_RECEIVER = "com.cursoandroid.pruebafragmentsimple.msgReceiver"

class FirstFragment : Fragment() {
    private var msgBundle: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            msgBundle = it.getString(MSG_RECEIVER)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(mensajeTextoParam: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(MSG_RECEIVER, mensajeTextoParam)
                }
            }
    }
}