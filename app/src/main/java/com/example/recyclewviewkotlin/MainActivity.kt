package com.example.recyclewviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclewviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var listadatos: MutableList<Adaptador> = mutableListOf()
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listadatos.add(Adaptador(("item 1")))
        listadatos.add(Adaptador(("item 2")))
        listadatos.add(Adaptador(("item 3")))
        listadatos.add(Adaptador(("item 4")))
        listadatos.add(Adaptador(("item 5")))
        listadatos.add(Adaptador(("item 6")))
        listadatos.add(Adaptador(("item 7")))
        listadatos.add(Adaptador(("item 8")))
        listadatos.add(Adaptador(("item 9")))
        listadatos.add(Adaptador(("item 10")))
        listadatos.add(Adaptador(("item 11")))
        listadatos.add(Adaptador(("item 12")))
        listadatos.add(Adaptador(("item 13")))
        listadatos.add(Adaptador(("item 14")))
        listadatos.add(Adaptador(("item 15")))

        establecerAdaptador()


    }
    private fun establecerAdaptador(){
        recycler = binding.lista
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = Reciclador(this,listadatos)
    }
}