package com.example.bankapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var btnSaldo: RadioButton?=null
    private var btnIngresar:RadioButton?=null
    private var btnRetirar:RadioButton?=null
    private var btnSalir:RadioButton?=null
    private var tvsaldo:TextView?=null
    private var txtingresar:EditText?=null
    private var txtretirar:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSaldo =findViewById(R.id.btnSaldo)
        btnIngresar=findViewById(R.id.btnIngresar)
        btnRetirar=findViewById(R.id.btnRetirar)
        btnSalir=findViewById(R.id.confirmButton)

        tvsaldo =findViewById(R.id.tvsaldo)
        txtingresar =findViewById(R.id.txtingresar)
        txtretirar =findViewById(R.id.txtretirar)
    }
    fun accion(view: View){
        tvsaldo?.visibility= View.INVISIBLE
        txtingresar?.visibility= View.INVISIBLE
        txtretirar?.visibility= View.INVISIBLE
        if (btnSaldo?.isChecked()==true){
            tvsaldo?.visibility=View.VISIBLE
            tvsaldo?.text="Tú Saldo es "
        }
        if (btnIngresar?.isChecked()==true){
            txtingresar?.visibility = View.VISIBLE
        }
        if (btnRetirar?.isChecked()==true){
            txtretirar?.visibility=View.VISIBLE
        }
        if (btnSalir?.isChecked()==true){
            tvsaldo?.visibility = View.VISIBLE
            tvsaldo?.text="Gracias por preferirnos"

        }
    }
}