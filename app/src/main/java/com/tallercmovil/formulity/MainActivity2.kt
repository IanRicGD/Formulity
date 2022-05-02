package com.tallercmovil.formulity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tallercmovil.formulity.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        val opcion = bundle?.getString("opcion", "")
        val parametro1 = bundle?.getDouble("par1",0.0)
        val parametro2 = bundle?.getDouble("par2",0.0)
        val parametro3 = bundle?.getDouble("par3",0.0)
        val resultado = bundle?.getString("resultado","")


        when (opcion) {
            "Volúmen Cilindro","Cylinder Volume","Volume du cylindre"-> {
                with(binding){
                    tvPar1.text=opcion
                    tvPar2.text=getString(R.string.stringMA2_3,"r", parametro1.toString())
                    tvPar3.text=getString(R.string.stringMA2_3,"h", parametro2.toString())
                    tvPar4.visibility=View.INVISIBLE
                    tvPar5.text=resultado
                }
            }
            "Volúmen Cono","Cone Volume","Volume du cône" -> {
                with(binding){
                    tvPar1.text=opcion
                    tvPar2.text=getString(R.string.stringMA2_3,"r", parametro1.toString())
                    tvPar3.text=getString(R.string.stringMA2_3,"h", parametro2.toString())
                    tvPar4.visibility=View.INVISIBLE
                    tvPar5.text=resultado
                }
            }
            else -> {
                with(binding){
                    tvPar1.text=opcion
                    tvPar2.text=getString(R.string.stringMA2_3,"a", parametro1.toString())
                    tvPar3.text=getString(R.string.stringMA2_3,"b", parametro2.toString())
                    tvPar4.text=getString(R.string.stringMA2_3,"c", parametro3.toString())
                    tvPar5.text=resultado
                }
            }
        }

    }
}