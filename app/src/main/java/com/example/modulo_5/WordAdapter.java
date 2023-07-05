package com.example.modulo_5;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.modulo_5.databinding.WordItemListBinding;

import java.util.List;
// 3 extiendo la clase wordadapter que contiene la clase interna wordviewholder
public class WordAdapter extends  RecyclerView.Adapter<WordAdapter.WordViewHolder>{

    //añadir representacion de los datos-----------------
    private List<String>mwordList;

    @NonNull
    //4 inicializa la vista y la infla, el contructor recibe un objeto le pasamos binding, instancamos  viewbinding para retornar nuestro viewholder con esa dependencia
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      WordItemListBinding mBinding = WordItemListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
              return new WordViewHolder(mBinding);
    }
//los setea , recibe una posicion y los va colocando
    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
String element = mwordList.get(position);
holder.textview.setText(element);
    }
//6 este metodo lleva la cuenta de cuantos elementos hay en el listado
    @Override
    public int getItemCount() {
        return mwordList.size();
    }

    // crear clase interna que se llama ViewHolder--------------------

    //inicializamos textview que esta dentro del xml y llamamos mbinding del mismo xml  que tiene textview
    //nos pedira implementar su contructor de la super clase
    //cambiamos el elemnto anterior y referenciamos a la clase binding que representa nuestro layout word item list
    public class WordViewHolder extends RecyclerView.ViewHolder{
        private TextView textview;
        public WordViewHolder(@NonNull WordItemListBinding mbinding){
            super(mbinding.getRoot());
            textview = mbinding.textView;
        }

    }
}
