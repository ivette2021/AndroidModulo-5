package com.example.listviewsud

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewsud.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val nombres = arrayOf(
        "Argentina", "Chile", "Uruguay", "Guayana", "Bolivia", "Peru",
        "Ecuador", "Brasil", "Colombia", "Venenzuela","Paraguay"
    )
    private val edades = arrayOf(
        "45 773 884", "19 629 590", "3 423 108", "813 834", "12 388 570", "34 352 718", "18 190 483", "216 422 446", "52 085 167", "28 838 498" ,"7 586 432"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        val adapter = ArrayAdapter(this, R.layout.list_item, nombres)
        binding.lv1.adapter = adapter

        binding.lv1.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, i, _ ->
                binding.tv1.text =
                    "La Poblacion de ${binding.lv1.getItemAtPosition(i)} es ${edades[i]} de personas"
            }
    }
}