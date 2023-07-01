package com.example.modulo_5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.modulo_5.databinding.FragmentLogoTriviaBinding;

public class LogoTriviaFragment extends Fragment {
    FragmentLogoTriviaBinding binding;
    private static final String ARG_NAME = "name";
    private String name;
    private boolean radioButtonChecked = false; // Variable para verificar si se selecciona el botón de radio


    public LogoTriviaFragment() {
        // Required empty public constructor
    }

    public static LogoTriviaFragment newInstance(String name) {
        LogoTriviaFragment fragment = new LogoTriviaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentLogoTriviaBinding.inflate(inflater, container, false);
       View view = binding.getRoot();
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            Log.d("LogoTriviaFragment", "Name argument: " + name);
        }

            String greeting = getString(R.string.greeting, name);
            binding.tvName.setText(greeting);


        return view;
    }
    // Método para establecer el nombre ingresado por el usuario
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener las referencias de los RadioButton utilizando binding

        RadioButton radioButton1 = binding.rb1;
        RadioButton radioButton2 = binding.rb2;
        RadioButton radioButton3 = binding.rb3;
        RadioButton radioButton4 = binding.rb4;
// "(buttonView, isChecked) -> "reemplaza new CompoundButton.OnCheckedChangeListener() y  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        radioButton1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked && !radioButtonChecked) { // Verificar que el botón se haya seleccionado y no se haya deseleccionado
                Navigation.findNavController(view).navigate(R.id.tryAgainFragment);
            }
            radioButtonChecked = isChecked; // Actualizar el estado de la variable radioButtonChecked
        });

        radioButton2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked && !radioButtonChecked) { // Verificar que el botón se haya seleccionado y no se haya deseleccionado
                Navigation.findNavController(view).navigate(R.id.tryAgainFragment);
            }
            radioButtonChecked = isChecked; // Actualizar el estado de la variable radioButtonChecked
        });

        radioButton3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked && !radioButtonChecked) { // Verificar que el botón se haya seleccionado y no se haya deseleccionado
                Navigation.findNavController(view).navigate(R.id.winFragment);
            }
            radioButtonChecked = isChecked; // Actualizar el estado de la variable radioButtonChecked
        });

        radioButton4.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked && !radioButtonChecked) { // Verificar que el botón se haya seleccionado y no se haya deseleccionado
                Navigation.findNavController(view).navigate(R.id.tryAgainFragment);
            }
            radioButtonChecked = isChecked; // Actualizar el estado de la variable radioButtonChecked
        });
    }

}