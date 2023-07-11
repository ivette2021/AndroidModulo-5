package com.example.kotlin
 // apartado A del ejercicio 22 v2
fun main() {
    //datos que da el ejercicio
    var num1 = 10
    var num2 = 33
    var num3 = 66

    // suma los 3 datos y se almacenan en la varibale suma
    var suma = num1 + num2 + num3
    //se ve el resultado en terminal
    println("La suma es: $suma")
//como usamos un var se puede sobrescribir la variable segun especificaciones
    num1 = 55
    suma = num1 + num2 + num3
    //aca cambia el resultado suma debido al cambio de num1
    println("La nueva suma es: $suma")

    var promedio = (num1 + num2 + num3) / 3.0
    println("El promedio es: $promedio")
}