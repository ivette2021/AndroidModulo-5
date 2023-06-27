package com.example.modulo5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.SurfaceControl;
import android.view.View;

import com.example.modulo5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private boolean isFragmentShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFragmentShow){
                   closeFragment();
                } else {
                    openFragment();
                }
            }
        });

        mBinding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment2("Ivette", "Valdivia");
            }
        });
    }
    private void openFragment(){
        // primer paso instaniar el fragmento
        QuestionFragment questionFragment =  new QuestionFragment();
        // 2 instancia del fragment manager
        FragmentManager manager = getSupportFragmentManager();
        // 3 crear la transaccion

            FragmentTransaction transaction = manager.beginTransaction().replace(mBinding.contenedor2.getId(),questionFragment, QuestionFragment.class.getSimpleName());
            transaction.commit();
            //transaction.remove(questionFragment).commit();
            mBinding.open.setText("cerrar");
            isFragmentShow = true;


    }
    private void closeFragment(){
//generar instancia del manager
        FragmentManager manager = getSupportFragmentManager();
        QuestionFragment questionFragment = (QuestionFragment) manager.findFragmentById(mBinding.contenedor2.getId());
        if ( questionFragment != null){
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(questionFragment).commit();
            mBinding.open.setText("abrir");
            isFragmentShow = false;
        }
    }
    private void openFragment2(String name, String lastname) {
        // primer paso instaniar el fragmento 2
        Fragment2 fragment2 = Fragment2.newInstance( name,  lastname);
        // 2 instancia del fragment manager
        FragmentManager manager = getSupportFragmentManager();
        // 3 verificar si el contenedor
        if (fragment2 != null) {

            FragmentTransaction transaction = manager.beginTransaction().replace(mBinding.contenedor.getId(),fragment2,Fragment2.class.getSimpleName());
            mBinding.button2.setText("cerrar");
            isFragmentShow = false;
            transaction.commit();
        }
    }
}