package com.example.modulo_5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.modulo_5.databinding.FragmentTitleBinding;

public class TitleFragment extends Fragment {

    FragmentTitleBinding binding;
    public TitleFragment newInstance() {
        TitleFragment fragment= new  TitleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentTitleBinding.inflate(inflater,container,false);
        View view  = binding.getRoot();
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!binding.etNombre.getText().toString().isEmpty()){
                    addLogoTriviaFragment(binding.etNombre.getText().toString());
                } else{
                    Toast.makeText(getContext(), "Ingrese su nombre", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
    private  void addLogoTriviaFragment(String name){
        Bundle bundle  = new Bundle();
        bundle.putString("clave1", name);
        Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_titleFragment_to_logoTriviaFragment,bundle);
    }
}