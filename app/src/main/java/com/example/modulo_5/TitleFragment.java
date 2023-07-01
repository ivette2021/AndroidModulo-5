package com.example.modulo_5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

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

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.etNombre.getText().toString();
                if (!name.isEmpty()) {
                    addLogoTriviaFragment(name);
                } else {
                    Toast.makeText(getContext(), "Ingrese su nombre", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}