package com.example.kotlin
import java.text.NumberFormat

fun suma(numero1: Double, numero2: Float): Double {
    return numero1 + numero2
}

fun redondeo(numero: Double): Double {
    return Math.ceil(numero)
}

fun muestraResultado(numero: Double) {
    val formatoMoneda = NumberFormat.getCurrencyInstance()
    val resultadoFormateado = formatoMoneda.format(numero)
    println(resultadoFormateado)
}

fun main() {
    val resultadoSuma = suma(10.5, 5.3f)
    println("Resultado de la suma: $resultadoSuma")

    val numeroRedondeado = redondeo(10.8)
    println("Número redondeado: $numeroRedondeado")

    muestraResultado(1234.56)
}
