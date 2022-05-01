package com.tallercmovil.formulity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.tallercmovil.formulity.databinding.ActivityMainBinding
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lista = resources.getStringArray(R.array.opciones)

        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista)

        binding.spnFormules.adapter=adaptador
        
        binding.spnFormules.onItemSelectedListener=object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (binding.spnFormules.selectedItem.toString()) {
                    lista[0] -> {
                        binding.ivFormula.setImageResource(R.drawable.volcil2)
                        binding.tvVar1.text=getString(R.string.tvCil_op1)
                        binding.etVar1.hint=getString(R.string.etCil_op1)

                        binding.tvVar2.text=getString(R.string.tvCil_op2)
                        binding.etVar2.hint=getString(R.string.etCil_op2)

                        binding.etVar3.visibility=View.INVISIBLE
                        binding.tvVar3.visibility=View.INVISIBLE

                    }
                    lista[1] -> {
                        binding.ivFormula.setImageResource(R.drawable.volcono2)
                        binding.tvVar1.text=getString(R.string.tvCon_op1)
                        binding.etVar1.hint=getString(R.string.etCon_op1)

                        binding.tvVar2.text=getString(R.string.tvCon_op2)
                        binding.etVar2.hint=getString(R.string.etCon_op2)

                        binding.etVar3.visibility=View.INVISIBLE
                        binding.tvVar3.visibility=View.INVISIBLE

                    }
                    else -> {
                        binding.ivFormula.setImageResource(R.drawable.volorto2)
                        binding.tvVar1.text=getString(R.string.tvOrt_op1)
                        binding.etVar1.hint=getString(R.string.etOrt_op1)

                        binding.tvVar2.text=getString(R.string.tvOrt_op2)
                        binding.etVar2.hint=getString(R.string.etOrt_op2)

                        binding.etVar3.visibility=View.VISIBLE
                        binding.tvVar3.visibility=View.VISIBLE
                        binding.tvVar3.text=getString(R.string.tvOrt_op3)
                        binding.etVar3.hint=getString(R.string.etOrt_op3)

                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }


    }

    fun click(view: View) {

        with(binding){
            val parametros = Bundle()
            val intent = Intent(this@MainActivity,MainActivity2::class.java)
            val lista = resources.getStringArray(R.array.opciones)
            val opcion = binding.spnFormules.selectedItem.toString()
            val df = DecimalFormat("#.####")
            df.roundingMode = RoundingMode.DOWN
            if (lista[0]==opcion){
                if(etVar1.text.toString().isNotEmpty() && etVar2.text.toString().isNotEmpty()){
                    val r = etVar1.text.toString().toDouble()
                    val h = etVar2.text.toString().toDouble()

                    val resultado = df.format(volumen("cilindro",r,h))

                    parametros.putString("opcion",opcion)
                    parametros.putDouble("par1",r)
                    parametros.putDouble("par2",h)
                    parametros.putString("resultado",resultado)
                    intent.putExtras(parametros)

                    startActivity(intent)

                }else{
                    if (etVar1.text.toString().isEmpty()){
                        etVar1.error=getString(R.string.etVar1Cil_error)
                        etVar1.requestFocus()
                    }
                    if (etVar2.text.toString().isEmpty()){
                        etVar2.error=getString(R.string.etVar2Cil_error)
                        etVar2.requestFocus()
                    }
                }
            }

            else if(lista[1]==opcion){
                if(etVar1.text.toString().isNotEmpty() && etVar2.text.toString().isNotEmpty()){
                    val r = etVar1.text.toString().toDouble()
                    val h = etVar2.text.toString().toDouble()

                    val resultado = df.format(volumen("cono",r,h))

                    parametros.putString("opcion",opcion)
                    parametros.putDouble("par1",r)
                    parametros.putDouble("par2",h)
                    parametros.putString("resultado",resultado)
                    intent.putExtras(parametros)

                    startActivity(intent)

                }else{
                    if (etVar1.text.toString().isEmpty()){
                        etVar1.error=getString(R.string.etVar1Con_error)
                        etVar1.requestFocus()
                    }
                    if (etVar2.text.toString().isEmpty()){
                        etVar2.error=getString(R.string.etVar2Con_error)
                        etVar2.requestFocus()
                    }
                }
            }

            else{
                if(etVar1.text.toString().isNotEmpty() && etVar2.text.toString().isNotEmpty() && etVar3.text.toString().isNotEmpty()){
                    val a = etVar1.text.toString().toDouble()
                    val b = etVar2.text.toString().toDouble()
                    val c = etVar3.text.toString().toDouble()

                    val resultado = df.format(volumen("ortoedro",a,b,c))

                    parametros.putString("opcion",opcion)
                    parametros.putDouble("par1",a)
                    parametros.putDouble("par2",b)
                    parametros.putDouble("par3",c)
                    parametros.putString("resultado",resultado)
                    intent.putExtras(parametros)

                    startActivity(intent)

                }else{
                    if (etVar1.text.toString().isEmpty()){
                        etVar1.error=getString(R.string.etVar1Ort_error)
                        etVar1.requestFocus()
                    }
                    if (etVar2.text.toString().isEmpty()){
                        etVar2.error=getString(R.string.etVar2Ort_error)
                        etVar2.requestFocus()
                    }
                    if (etVar3.text.toString().isEmpty()){
                        etVar3.error=getString(R.string.etVar3Ort_error)
                        etVar3.requestFocus()
                    }
                }
            }
        }
    }

    private fun volumen(objeto:String, par1:Double, par2:Double, par3:Double=0.0):Double{
        return when (objeto) {
            "cilindro" -> {
                PI * (par1.pow(2)) * par2
            }
            "cono" -> {
                (PI * (par1.pow(2)) * par2) / (3)
            }
            else -> {
                par1*par2*par3
            }
        }
    }
}