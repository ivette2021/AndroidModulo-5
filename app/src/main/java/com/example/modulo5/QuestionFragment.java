package com.example.modulo5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.modulo5.databinding.FragmentQuestionBinding;

public class QuestionFragment extends Fragment {

private FragmentQuestionBinding mBinding;
    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     mBinding = FragmentQuestionBinding.inflate(inflater, container, false);
     return mBinding.getRoot();
    }
}