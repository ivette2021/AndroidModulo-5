package com.example.bankapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.example.bankapp.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var saldo = 500.000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rbSaldo.setOnClickListener { accion() }
        binding.rbIngresar.setOnClickListener { accion() }
        binding.rbRetirar.setOnClickListener { accion() }
        binding.rbSalir.setOnClickListener { accion() }

        binding.confirmButton.setOnClickListener { btnConfirmar() }
    }

    private fun accion() {
        binding.tvsaldo.visibility = View.INVISIBLE
        binding.txtingresar.visibility = View.INVISIBLE
        binding.txtretirar.visibility = View.INVISIBLE

        when {
            binding.rbSaldo.isChecked -> {
                binding.tvsaldo.visibility = View.VISIBLE
                binding.tvsaldo.text = "Tú Saldo es $saldo"
            }
            binding.rbIngresar.isChecked -> {
                binding.txtingresar.visibility = View.VISIBLE
            }
            binding.rbRetirar.isChecked -> {
                binding.txtretirar.visibility = View.VISIBLE
            }
            binding.rbSalir.isChecked -> {
                binding.tvsaldo.visibility = View.VISIBLE
                binding.tvsaldo.text = "Gracias por preferirnos"
            }
        }
    }

    private fun btnConfirmar() {
        binding.tvsaldo.visibility = View.INVISIBLE
        binding.txtingresar.visibility = View.INVISIBLE
        binding.txtretirar.visibility = View.INVISIBLE

        when {
            binding.rbSaldo.isChecked -> {
                binding.tvsaldo.text = "Tú Saldo es $saldo"
                binding.tvsaldo.visibility = View.VISIBLE
            }
            binding.rbIngresar.isChecked -> {
                val ingresar = binding.txtingresar.text.toString().toDouble()
                saldo += ingresar
                binding.tvsaldo.text = "Tú Saldo es $saldo"
                binding.tvsaldo.visibility = View.VISIBLE
                Toast.makeText(this, "Tu operación se realizó de forma exitosa", Toast.LENGTH_LONG).show()
            }
            binding.rbRetirar.isChecked -> {
                val retirar = binding.txtretirar.text.toString().toDouble()
                if (saldo - retirar < 0.0) {
                    binding.tvsaldo.visibility = View.VISIBLE
                    binding.tvsaldo.text = "Saldo Insuficiente"
                } else {
                    saldo -= retirar
                    binding.tvsaldo.text = "Tu saldo es de $saldo"
                    binding.tvsaldo.visibility = View.VISIBLE
                    Toast.makeText(this, "Tu operación se realizó de forma exitosa", Toast.LENGTH_LONG).show()
                }
            }
            binding.rbSalir.isChecked -> {
                binding.tvsaldo.visibility = View.VISIBLE
                binding.tvsaldo.text = "Tu operación se realizó de forma exitosa"
                finish()
                System.exit(0)
            }
        }
    }
}
