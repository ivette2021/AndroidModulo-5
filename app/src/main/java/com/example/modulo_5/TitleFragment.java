package com.example.modulo_5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.modulo_5.databinding.FragmentTitleBinding;

public class TitleFragment extends Fragment {

    FragmentTitleBinding binding;

    public static TitleFragment newInstance() {
        return new TitleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTitleBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        return view;
    }
    @Override //cuando agregamos estas lineas se ve el fragment de perder o ganar
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


            binding.btn1.setOnClickListener(v -> {

                String name = binding.etNombre.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(getContext(),"ingrese su nombre ",Toast.LENGTH_SHORT).show();
                }
                else {
                    LogoTriviaFragment logoTriviaFragment = LogoTriviaFragment.newInstance(name);
                    logoTriviaFragment.setName(name);
                    Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_logoTriviaFragment);
                }
            // Navegar al fragmento LogoTriviaFragment al hacer clic en el botón "Comenzar"
        });
    }

    private void addLogoTriviaFragment(String name) {
        LogoTriviaFragment logoTriviaFragment = LogoTriviaFragment.newInstance(name);
        logoTriviaFragment.setName(name);

        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, logoTriviaFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}