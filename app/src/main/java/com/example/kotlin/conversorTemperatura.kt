package com.example.kotlin

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Ingrese una temperatura con coma NO PUNTO:")
    val temperatura = scanner.nextDouble()

    println("Ingrese la escala de temperatura:")
    println("1. Celsius")
    println("2. Fahrenheit")
    println("3. Kelvin")
    println("4. todas las escalas")
    val opcion = scanner.nextInt()

    when (opcion) {
        1 -> convertirDeCelsius(temperatura)
        2 -> convertirDeFahrenheit(temperatura)
        3 -> convertirDeKelvin(temperatura)
        4 -> convertirTodo(temperatura)
        else -> println("Opción inválida")
    }
}

fun convertirTodo(temperatura: Double) {
    val celsius = (temperatura - 32) * (5.0 / 9.0)
    val fahrenheit = (9.0 / 5.0 * temperatura) + 32
    val kelvin = temperatura + 273.15

    println("Temperatura en Celsius: ${String.format("%.2f", temperatura)} °C")
    println("Temperatura en Fahrenheit: ${String.format("%.2f", fahrenheit)} °F")
    println("Temperatura en Kelvin: ${String.format("%.2f", kelvin)} K")
}

fun convertirDeCelsius(temperatura: Double) {

    println("Temperatura en Celsius: ${String.format("%.2f", temperatura)} °C")

}

fun convertirDeFahrenheit(temperatura: Double) {

    val fahrenheit = (9.0 / 5.0 * temperatura) + 32
    println("Temperatura en Fahrenheit: ${String.format("%.2f", fahrenheit)} °F")

}

fun convertirDeKelvin(temperatura: Double) {

    val kelvin = (temperatura + 273.15)
    println("Temperatura en Kelvin: ${String.format("%.2f", kelvin)} K")

}