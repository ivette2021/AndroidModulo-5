package com.example.contraseamvp



class PasswordPresenter(private val view: PasswordView) {

    fun checkPasswordStrength(password: String) {
        val strength = calculatePasswordStrength(password)
        view.showPasswordStrength(strength)
    }

    private fun calculatePasswordStrength(password: String): PasswordStrength {
        return PasswordUtils.calculatePasswordStrength(password)
    }
}