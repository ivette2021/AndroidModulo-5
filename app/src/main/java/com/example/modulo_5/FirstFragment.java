package com.example.modulo_5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.modulo_5.databinding.ActivityMainBinding;
import com.example.modulo_5.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    //1.- creamos un list que represente los datos
    private List<String>datalist = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentFirstBinding.inflate(inflater, container,false);

       return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // PARA PROBAR QUE HAY DATOS
        /***  1 instanciar el adapter y le pasamos los datos con las palabras ***/

        WordAdapter adapter = new WordAdapter(setData());

        /*** 2 pasamos el adapter al recycleview ***/

        binding.Rv.setAdapter(adapter); //estamos seteando los datos

        /**  3 indicamos al recyclerview como mostrar datos**/

        binding.Rv.setLayoutManager(new LinearLayoutManager(getContext()));//le decimos como se mostraran

        binding.Rv.setHasFixedSize(true); //vaya mostrando los datos nuevos al final

        /******************LÓGICA del button******************************************************************/


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datalist.add("PALABRA"+ datalist.size());
                // notificar al adapter que se insertaron los datos

                Objects.requireNonNull(binding.Rv.getAdapter()).notifyItemInserted(datalist.size());
                // scroll al final de la lista
                binding.Rv.smoothScrollToPosition(datalist.size());
            }
        });
        //aqui continua la escucha de los textos
        WordAdapter adapter1 = new WordAdapter(datalist);
        adapter1.setOnItemClickListener(new WordAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                datalist.set(position,"clicked!"+datalist.get(position));
                Objects.requireNonNull(binding.Rv.getAdapter()).notifyItemChanged(position);


            }
        });
        binding.Rv.setAdapter(adapter1);
    }
    // 2 crear un listado de palabras
    private List<String> setData() {

            datalist.add("Palabra: " );

        return datalist;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}