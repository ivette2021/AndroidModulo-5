package com.example.shoestap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shoestap.databinding.FragmentThirdBinding
import android.content.Context
import android.content.SharedPreferences

class ThirdFragment : Fragment() {

    private var binding: FragmentThirdBinding? = null
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var cartItems: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getSharedPreferences("my_preference", Context.MODE_PRIVATE)
        cartItems = sharedPreferences.getString("cart_items", "0") ?: "0" // "0" es el valor predeterminado si no se encuentra ninguna entrada con la clave "cart_items"
        binding?.btnAtras?.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding?.btnClearCart?.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString("cart_items", "0")
            editor.apply()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}