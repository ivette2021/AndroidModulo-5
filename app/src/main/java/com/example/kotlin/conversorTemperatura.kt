package com.example.kotlin

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Ingrese una temperatura:")
    val temperatura = scanner.nextDouble()

    println("Ingrese la escala de temperatura:")
    println("1. Celsius")
    println("2. Fahrenheit")
    println("3. Kelvin")
    val opcion = scanner.nextInt()

    when (opcion) {
        1 -> convertirDeCelsius(temperatura)
        2 -> convertirDeFahrenheit(temperatura)
        3 -> convertirDeKelvin(temperatura)
        else -> println("Opción inválida")
    }
}

fun convertirDeCelsius(temperatura: Double) {
    val fahrenheit = (9.0 / 5.0 * temperatura) + 32
    val kelvin = temperatura + 273.15

    println("Temperatura en Celsius: ${String.format("%.2f", temperatura)} °C")
    println("Temperatura en Fahrenheit: ${String.format("%.2f", fahrenheit)} °F")
    println("Temperatura en Kelvin: ${String.format("%.2f", kelvin)} K")
}

fun convertirDeFahrenheit(temperatura: Double) {
    val celsius = (temperatura - 32) * (5.0 / 9.0)
    val kelvin = (temperatura - 32) * (5.0 / 9.0) + 273.15

    println("Temperatura en Fahrenheit: ${String.format("%.2f", temperatura)} °F")
    println("Temperatura en Celsius: ${String.format("%.2f", celsius)} °C")
    println("Temperatura en Kelvin: ${String.format("%.2f", kelvin)} K")
}

fun convertirDeKelvin(temperatura: Double) {
    val celsius = temperatura - 273.15
    val fahrenheit = (temperatura - 273.15) * (9.0 / 5.0) + 32

    println("Temperatura en Kelvin: ${String.format("%.2f", temperatura)} K")
    println("Temperatura en Celsius: ${String.format("%.2f", celsius)} °C")
    println("Temperatura en Fahrenheit: ${String.format("%.2f", fahrenheit)} °F")
}