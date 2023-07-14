package com.example.contraseamvp

enum class PasswordStrength {
    WEAK,
    MEDIUM,
    STRONG
}

object PasswordUtils {
    fun calculatePasswordStrength(password: String): PasswordStrength {
        return when {
            password.length < 6 -> PasswordStrength.WEAK
            password.length < 10 -> PasswordStrength.MEDIUM
            else -> PasswordStrength.STRONG
        }
    }
}