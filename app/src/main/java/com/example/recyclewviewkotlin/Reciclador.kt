package com.example.recyclewviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Reciclador(var context: Context, var listaDatos: MutableList<Adaptador>):RecyclerView.Adapter<Reciclador.MiHolder>() {


    inner class MiHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var labelNombre: TextView

        init {
            labelNombre = itemView.findViewById(R.id.tv_nombre)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return  MiHolder(itemView)
    }

    override fun onBindViewHolder(holder:MiHolder, position: Int) {
        var adaptador = listaDatos[position]
        holder.labelNombre.text = adaptador.nombre
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }
}