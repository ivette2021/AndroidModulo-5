package com.example.shoestap

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.shoestap.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        binding.fab.setOnClickListener {
            val thirdFragment = ThirdFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, thirdFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d("MiTag", "Mensaje de depuración")
        when (item.itemId) {
            R.id.home -> {
                val homeFragment = FirstFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, homeFragment)
                    .addToBackStack(null)
                    .commit()
                return true
            }
            R.id.favoritos -> {
                val favoritosFragment = FavoritosFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, favoritosFragment)
                    .addToBackStack(null)
                    .commit()
                return true
            }
            R.id.pago -> {
                val pagoFragment = PagoFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, pagoFragment)
                    .addToBackStack(null)
                    .commit()
                return true
            }
            R.id.perfil -> {
                val perfilFragment = PerfilFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, perfilFragment)
                    .addToBackStack(null)
                    .commit()
                return true
            }
        }
        return false
    }
}
