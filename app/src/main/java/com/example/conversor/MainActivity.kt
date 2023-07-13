package com.example.conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.conversor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val sp1 = binding.sp1
        val sp2 = binding.sp2
        val lista = resources.getStringArray(R.array.divisas)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        var posicionSP1 = ""
        var posicionSP2 = ""
        val cantidad = binding.etCantidad
        val resultado = binding.tvResultado
        var total = 0.0

        sp1.adapter = adapter
        sp2.adapter = adapter

        sp1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                posicionSP1 = lista[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Error al traer las divisas", Toast.LENGTH_LONG)
                    .show()
            }
        }
        sp2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                posicionSP2 = lista[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Error al traer las divisas", Toast.LENGTH_LONG)
                    .show()
            }
        }
        binding.btnEnviar.setOnClickListener {
            if (cantidad.text.isNotEmpty()) {
                when (posicionSP1) {
                    "CLP" -> {
                        when (posicionSP2) {
                            "CLP" -> {
                                resultado.text = cantidad.text
                            }

                            "USD" -> {
                                total = cantidad.text.toString().toFloat() * .0012
                                resultado.text = total.toString()
                            }

                            "EUR" -> {
                                total = cantidad.text.toString().toFloat() * .0011
                                resultado.text = total.toString()
                            }
                        }
                    }

                    "USD" -> {
                        when (posicionSP2) {
                            "USD" -> {
                                resultado.text = cantidad.text
                            }

                            "CLP" -> {
                                total = cantidad.text.toString().toFloat() * 809.50
                                resultado.text = total.toString()
                            }

                            "EUR" -> {
                                total = cantidad.text.toString().toFloat() * .89
                                resultado.text = total.toString()
                            }
                        }
                    }

                    "EUR" -> {
                        when (posicionSP2) {
                            "EUR" -> {
                                resultado.text = cantidad.text
                            }

                            "USD" -> {
                                total = cantidad.text.toString().toFloat() * 1.12
                                resultado.text = total.toString()
                            }

                            "CLP" -> {
                                total = cantidad.text.toString().toFloat() * 908.63
                                resultado.text = total.toString()
                            }
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Ingrese una cantidad!!", Toast.LENGTH_LONG).show()
            }
        }
    }

}