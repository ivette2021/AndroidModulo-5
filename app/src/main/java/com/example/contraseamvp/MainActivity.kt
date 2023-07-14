package com.example.contraseamvp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.contraseamvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PasswordView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: PasswordPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter = PasswordPresenter(this)

        binding.checkStrengthButton.setOnClickListener {
            val password = binding.passwordEditText.text.toString()
            presenter.checkPasswordStrength(password)
        }

        binding.passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                binding.passwordStrengthTextView.text = ""
            }
        })
    }

    override fun showPasswordStrength(strength: PasswordStrength) {
        val color = when (strength) {
            PasswordStrength.WEAK -> android.R.color.holo_red_light
            PasswordStrength.MEDIUM -> android.R.color.holo_orange_light
            PasswordStrength.STRONG -> android.R.color.holo_green_light
        }

        binding.passwordStrengthTextView.setText(R.string.check_strength)
        binding.passwordStrengthTextView.setTextColor(getColor(color))
    }
}