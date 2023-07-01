package com.example.modulo_5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.modulo_5.databinding.FragmentWinBinding;

public class WinFragment extends Fragment {
   private FragmentWinBinding binding;

    public WinFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWinBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
// (v -> { se utiliza para definir el método OnClickListener de forma concisa y simplificada.
        @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button4.setOnClickListener(v -> {
        NavController navController= Navigation.findNavController(view);
        navController.navigate(R.id.titleFragment);
        });
    }
    // destruir el fragmento
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}