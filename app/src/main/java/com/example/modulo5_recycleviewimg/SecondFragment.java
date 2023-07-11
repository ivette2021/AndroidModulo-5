package com.example.modulo5_recycleviewimg;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.modulo5_recycleviewimg.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
binding.button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        FirstFragment firstFragment = new FirstFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, firstFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
});
        Bundle bundle = getArguments();
        if (bundle != null) {
            String url = bundle.getString("url");
            String datos = bundle.getString("datos");

            // Cargar la imagen usando Glide o Picasso
            Glide.with(requireContext())
                    .load(url)
                    .into(binding.imageView);

            // Mostrar los datos adicionales
            binding.textView2.setText(datos);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}