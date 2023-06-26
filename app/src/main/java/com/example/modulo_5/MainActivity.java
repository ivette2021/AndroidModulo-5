package com.example.modulo_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.modulo_5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding mBinding;
    private EditText texto1;
    private Button boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


        texto1 = mBinding.editTxt;
        boton = mBinding.button;
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarFragmento();
            }
        });
    }
    private void  mostrarFragmento(){
    //crear instania del fragmento
        BlankFragment fragment = BlankFragment.newInstance(texto1.getText().toString(),"");
        //obtener el administrador de los fragmentos
        FragmentManager fragmentManager = getSupportFragmentManager();
        //iniciar transaccion del fragmento
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //reemplazar el contenido del contenedor con el fragmento
        transaction.replace(mBinding.container.getId(), fragment);
        //opcional : añadir la transacion la pila de retroeso
        transaction.addToBackStack(null);
        transaction.commit();

    }
}