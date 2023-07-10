package com.example.modulo_5;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.modulo_5.databinding.WordItemListBinding;

import java.util.List;

/*** 3 extiendo la clase wordadapter que contiene la clase interna wordviewholder ***/
public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    /***** 1 añadir representacion de los datos ***********/
    private List<String> mwordList;
    // se agrega un itemclicklistener para los eventos de las textos añadidos
    private OnItemClickListener listener;
    //alamacena la posicion de la palabra como tal
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    //se creo un contructor para la escucha del evento
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    /***** 7 constructor que recibe los datos desde el otra ventana  ***********/
    public WordAdapter(List<String> mwordList) {
        this.mwordList = mwordList;
    }

    /******* 4 inicializa la vista y la infla, el contructor recibe un objeto le pasamos binding, instancamos  viewbinding para retornar nuestro viewholder con esa dependencia *****/
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WordItemListBinding mBinding = WordItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext()); //1
        //  ItemWordBinding binding = ItemWordBinding.inflate(inflater, parent, false);//2
        return new WordViewHolder(mBinding);
    }

    //**** 5 los setea , recibe una posicion y los va colocando , asignamos el valor especifico de una lista  de datos a la vista visual correspondiente al recycle view
    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String element = mwordList.get(position);
        holder.textview.setText(element);
        // se agrego una escucha de los textos
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });
    }



    /****** 6 este metodo lleva la cuenta de cuantos elementos hay en el listado  ****/
    @Override
    public int getItemCount() {
        return mwordList.size();
    }

    /*** 2 crear clase interna que se llama ViewHolder****************************/

    //inicializamos textview que esta dentro del xml y llamamos mbinding del mismo xml  que tiene textview
    //nos pedira implementar su contructor de la super clase
    //cambiamos el elemnto anterior y referenciamos a la clase binding que representa nuestro layout word item list
    public class WordViewHolder extends RecyclerView.ViewHolder {
        private TextView textview;

        public WordViewHolder(@NonNull WordItemListBinding mbinding) {
            super(mbinding.getRoot());
            textview = mbinding.textView;
        }

    }
}
