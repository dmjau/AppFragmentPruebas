package com.cursoandroid.pruebafragmentsimple

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_second.*

private const val MSG_RECEIVER = "com.cursoandroid.pruebafragmentsimple.msgReceiver"

class SecondFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        second_fragment_textView.text = msgBundle.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(mensajeTextReceive: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(MSG_RECEIVER, mensajeTextReceive)
                }
            }
    }
}