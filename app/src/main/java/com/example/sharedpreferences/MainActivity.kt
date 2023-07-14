package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: SharedPreferences

    private val ENTERO_KEY = "entero_key"
    private val TEXTO_KEY = "texto_key"
    private val SWITCH_KEY = "switch_key"
    private val DECIMAL_KEY = "decimal_key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)

        binding.btnBorrar.setOnClickListener {
            borrarPreferencias()
        }

        binding.btnGuardar.setOnClickListener {
            guardarPreferencias()
        }

        cargarPreferencias()
    }

    private fun guardarPreferencias() {
        val enteroValue = binding.etEntero.text.toString().toIntOrNull()
        val textoValue = binding.etTexto.text.toString()
        val switchValue = binding.switch1.isChecked
        val decimalValue = binding.etDecimal.text.toString().toFloatOrNull()

        if (enteroValue != null && textoValue.isNotEmpty() && decimalValue != null) {
            val editor = sharedPref.edit()
            editor.putInt(ENTERO_KEY, enteroValue)
            editor.putString(TEXTO_KEY, textoValue)
            editor.putBoolean(SWITCH_KEY, switchValue)
            editor.putFloat(DECIMAL_KEY, decimalValue)
            editor.apply()

            Toast.makeText(this, "Preferencias guardadas", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cargarPreferencias() {
        val enteroValue = sharedPref.getInt(ENTERO_KEY, 0)
        val textoValue = sharedPref.getString(TEXTO_KEY, "")
        val switchValue = sharedPref.getBoolean(SWITCH_KEY, false)
        val decimalValue = sharedPref.getFloat(DECIMAL_KEY, 0f)

        binding.etEntero.setText(enteroValue.toString())
        binding.etTexto.setText(textoValue)
        binding.switch1.isChecked = switchValue
        binding.etDecimal.setText(decimalValue.toString())
    }

    private fun borrarPreferencias() {
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()

        binding.etEntero.setText("")
        binding.etTexto.setText("")
        binding.switch1.isChecked = false
        binding.etDecimal.setText("")

        Toast.makeText(this, "Preferencias borradas", Toast.LENGTH_SHORT).show()
    }
}
