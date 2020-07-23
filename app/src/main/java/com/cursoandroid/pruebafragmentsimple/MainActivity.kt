package com.cursoandroid.pruebafragmentsimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_third.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Este boton no hace mas que lanzar el fragment y mostrarlo.
        main_btn_simple.setOnClickListener{
            val firstFragment = FirstFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fragmentContainer, firstFragment)
            fragmentTransaction.commit()
        }
        //Este boton lanza un fragment con un mensaje desde el activity main.
        main_btn_mensaje.setOnClickListener {
            val secondFragment = SecondFragment.newInstance("Hola! este mensaje llega desde el MAIN")
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer, secondFragment)
            fragmentTransaction.commit()
        }
        //Este boton toma texto del main activity y lo envia al tercer fragment
        main_btn_texto.setOnClickListener {
            val textoEnCampo = main_EditText.text.toString()
            val thirdFragment = ThirdFragment.newInstance(textoEnCampo)
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer, thirdFragment)
            fragmentTransaction.commit()
        }
        //Este boton lleva un texto del main al 4to fragment, el 4to fragment ingresa un texto y lo manda al 5to fragment
        main_btn_fourth.setOnClickListener {
            val inputTextMain = main_EditText.text.toString()
            //creamos el fragment que va a enviar el texto del editText del MainActivity
            val fourthFragment = FourthFragment.newInstance(inputTextMain)
            //el fragmentTransaction es la funcionalidad para manejar las transacciones, y el supportFragmentManager es una funcionalidad que me devuelve un fragmento.
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            //Esta es la funcion que me reemplaza un fragment en pantalla, le indicamos el container del fragment, y el objeto fragment generado en el mainactivity
            fragmentTransaction.replace(R.id.fragmentContainer, fourthFragment)
            fragmentTransaction.commit()
        }
    }
}