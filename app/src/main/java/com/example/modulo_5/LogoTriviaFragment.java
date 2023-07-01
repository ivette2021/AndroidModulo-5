package com.example.modulo_5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.modulo_5.databinding.FragmentLogoTriviaBinding;

public class LogoTriviaFragment extends Fragment {
    FragmentLogoTriviaBinding binding;
    private static final String ARG_NAME = "name";
    private String name;


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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentLogoTriviaBinding.inflate(inflater, container, false);
       View view = binding.getRoot();

            String greeting = getString(R.string.greeting, name);
            binding.tvName.setText(greeting);

//define cual boton tendra la respuesta correcta
        RadioButton radioButton1 = binding.rb1;
        RadioButton radioButton2 = binding.rb2;
        RadioButton radioButton3 = binding.rb3;
        RadioButton radioButton4 = binding.rb4;
// "(buttonView, isChecked) -> "reemplaza new CompoundButton.OnCheckedChangeListener() y  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        radioButton1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Navigation.findNavController(view).navigate(R.id.tryAgainFragment);
            }
        });

        radioButton2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Navigation.findNavController(view).navigate(R.id.tryAgainFragment);
            }
        });

        radioButton3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Navigation.findNavController(view).navigate(R.id.winFragment);
            }
        });

        radioButton4.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Navigation.findNavController(view).navigate(R.id.tryAgainFragment);
            }
        });

        return view;
    }
    // Método para establecer el nombre ingresado por el usuario
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}