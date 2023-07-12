package com.example.kotlin
data class Usuario(val nombre: String, val apellido: String, val edad: Int, val correo: String, val sistemaSalud: String)

fun registrarUsuarios() {
    println("Ingrese la cantidad de usuarios a registrar:")
    val cantidad = readLine()?.toIntOrNull() ?: 0
    val usuarios = mutableListOf<Usuario>()

    for (i in 1..cantidad) {
        println("Usuario $i:")
        val nombre = solicitarNombre()
        val apellido = solicitarApellido()
        val edad = solicitarEdad()
        val correo = solicitarCorreo()
        val sistemaSalud = solicitarSistemaSalud()
        val usuario = Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)
    }

    val usuariosOrdenados = usuarios.sortedBy { it.edad }
    println("Usuarios registrados:")
    usuariosOrdenados.forEach { //dice que realizara la opcion para todos los usuarios que hayas indicado
        println("Nombre: ${it.nombre}, Apellido: ${it.apellido}, Edad: ${it.edad}, Correo: ${it.correo}, Sistema de Salud: ${it.sistemaSalud}")
    }
}

fun solicitarNombre(): String {
    while (true) {
        println("Ingrese el nombre:")
        val nombre = readLine()?.trim() ?: "" //el operador elvis ?: se utiliza para proporcionar un valor de respaldo en caso de que la cadena capturada sea nula
        if (nombre.length in 1..20 && nombre.all { it.isLetter() }) { //se delimita el nombre de 1 a 20 caracteres y verificamos que cada caracter sea una letra con "all" y isLetter
            return nombre
        } else {
            println("Nombre inválido. Debe tener entre 1 y 20 caracteres y contener solo letras.")
        }
    }
}
fun solicitarApellido(): String {
    while (true) {
        println("Ingrese el apellido:")
        val apellido = readLine()?.trim() ?: ""
        if (apellido.all { it.isLetter() }) {
            return apellido
        } else {
            println("Apellido inválido. Debe contener solo letras.")
        }
    }
}
fun solicitarEdad(): Int {
    while (true) {
        println("Ingrese la edad:")
        val edad = readLine()?.toIntOrNull()//se lee la entrada por consola y se castea a integer
        if (edad != null && edad >= 0) {
            return edad
        } else {
            println("Edad inválida. Debe ser un número entero positivo.")
        }
    }
}
fun solicitarCorreo(): String {
    while (true) {
        println("Ingrese el correo:")
        val correo = readLine()?.trim() ?: "" //Si el valor devuelto por readLine() es nulo, el operador ?. evitará una excepción de NullPointerException.
        if (correo.matches(Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"))) { //verifica si coincide con formato de correo
            return correo
        } else {
            println("Correo inválido. Debe tener formato de correo válido.")
        }
    }
}
fun solicitarSistemaSalud(): String {
    while (true) {
        println("Ingrese el sistema de salud (Fonasa/Isapre/Particular):")
        val sistemaSalud = readLine()?.trim()?.toLowerCase() ?: ""
        if (sistemaSalud in listOf("fonasa", "isapre", "particular")) {
            return sistemaSalud.capitalize()
        } else {
            println("Sistema de salud inválido. Debe seleccionar una opción válida.")
        }
    }
}

fun main() {
    registrarUsuarios()
}