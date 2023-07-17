package com.example.shoestap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.example.shoestap.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var binding: FragmentSecondBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnAtras?.setOnClickListener {
            val firstFragment = FirstFragment()
            val fragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainerView, firstFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        val bundle = arguments
        if (bundle != null) {
            val url = bundle.getString("url")
            val datos = bundle.getString("datos")

            // Cargar la imagen usando Glide o Picasso, se uso into para pasar directamente las ref. a imageview como parametro
            binding?.imageView?.let {
                Glide.with(requireContext())
                    .load(url)
                    .into(it)
            }

            // Mostrar los datos adicionales
            binding?.tvNombreArticulo?.text = datos
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
