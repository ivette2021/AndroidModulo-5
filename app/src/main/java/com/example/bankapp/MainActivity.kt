package com.example.bankapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var rbSaldo: RadioButton?=null
    private var rbIngresar:RadioButton?=null
    private var rbRetirar:RadioButton?=null
    private var rbSalir:RadioButton?=null
    private var tvsaldo:TextView?=null
    private var txtingresar:EditText?=null
    private var txtretirar:EditText?=null

    private var saldo=500.000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rbSaldo =findViewById(R.id.rbSaldo)
        rbIngresar=findViewById(R.id.rbIngresar)
        rbRetirar=findViewById(R.id.rbRetirar)
        rbSalir=findViewById(R.id.confirmButton)

        tvsaldo =findViewById(R.id.tvsaldo)
        txtingresar =findViewById(R.id.txtingresar)
        txtretirar =findViewById(R.id.txtretirar)
    }
    fun accion(view: View){
        tvsaldo?.visibility= View.INVISIBLE
        txtingresar?.visibility= View.INVISIBLE
        txtretirar?.visibility= View.INVISIBLE
        if (rbSaldo?.isChecked()==true){
            tvsaldo?.visibility=View.VISIBLE
            tvsaldo?.text="Tú Saldo es $saldo "
        }
        if (rbIngresar?.isChecked()==true){
            txtingresar?.visibility = View.VISIBLE
        }
        if (rbRetirar?.isChecked()==true){
            txtretirar?.visibility=View.VISIBLE
        }
        if (rbSalir?.isChecked()==true){
            tvsaldo?.visibility = View.VISIBLE
            tvsaldo?.text="Gracias por preferirnos"
        }
    }
    fun rbConfirmar(view: View){
        tvsaldo?.visibility= View.INVISIBLE
        txtingresar?.visibility= View.INVISIBLE
        txtretirar?.visibility= View.INVISIBLE
        if (rbSaldo?.isChecked()==true){
            tvsaldo?.visibility=View.VISIBLE
            tvsaldo?.text="Tú Saldo es $saldo "
        }
        if (rbIngresar?.isChecked()==true){
            var ingresar=txtingresar?.text.toString().toDouble()
            saldo=saldo+ingresar
            tvsaldo?.text="Tú Saldo es $saldo "
            Toast.makeText(this,"tu operacion se realizo de forma exitos", Toast.LENGTH_LONG).show()
        }
        if (rbRetirar?.isChecked()==true){
            var retirar= txtretirar?.text.toString().toDouble()
            if(saldo-retirar <0.0){
                tvsaldo?.text="Saldo Insuficiente"
        }else{
            saldo= saldo-retirar
            tvsaldo?.text="su saldo es de $saldo"
            Toast.makeText(this,"tu operacion se realizo de forma exitosa",Toast.LENGTH_LONG).show()
        }
        if (rbSalir?.isChecked()==true){
            tvsaldo?.visibility = View.VISIBLE
            tvsaldo?.text="tu operacion se realizo de forma exitosa"
            finish()
            System.exit(0)
        }
    }
}}