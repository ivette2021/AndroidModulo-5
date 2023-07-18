package com.example.shoestap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Adapter(private val dataList: List<datosLista>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]

        holder.textView.text = data.dato
        Glide.with(holder.itemView).load(data.url).into(holder.imageView)

        holder.itemView.setOnClickListener {
            val position = holder.bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val eleccion = dataList[position]
                val bundle = Bundle().apply {
                    putString("url", eleccion.url)
                    putString("datos", eleccion.dato)
                    putString("precio", eleccion.precio)
                    putString("pDescription", eleccion.pDescription)
                }

                val fragment = SecondFragment()
                fragment.arguments = bundle
                val fragmentManager = (holder.itemView.context as FragmentActivity).supportFragmentManager
                fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }

        holder.fab.setOnClickListener {
            val position = holder.bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val eleccion = dataList[position]
                val bundle = Bundle().apply {
                    putString("url", eleccion.url)
                    putString("datos", eleccion.dato)
                    putString("precio", eleccion.precio)
                    putString("pDescription", eleccion.pDescription)
                }

                val fragment = ThirdFragment()
                fragment.arguments = bundle
                val fragmentManager = (holder.fab.context as FragmentActivity).supportFragmentManager
                fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tv_nombre_articulo)
        val imageView: ImageView = itemView.findViewById(R.id.imageView2)
        val fab: FloatingActionButton = itemView.findViewById(R.id.fab)
    }
}
