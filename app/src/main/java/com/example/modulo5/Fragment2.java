package com.example.modulo5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.modulo5.databinding.Fragment2Binding;

public class Fragment2 extends Fragment {

    private Fragment2Binding mBinding;
    private String name;
    private String lastname;

    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInstance(String name, String lastname) {
        Fragment2 fragment2 = new Fragment2();
        Bundle args = new Bundle();
        args.putString("clave1", name);
        args.putString("clave2", lastname);
        fragment2.setArguments(args);
        return fragment2;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString("clave1");
            lastname = getArguments().getString("clave2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = Fragment2Binding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.name.setText(name);
        mBinding.lastname.setText(lastname);
    }
}