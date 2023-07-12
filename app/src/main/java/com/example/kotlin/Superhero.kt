package com.example.kotlin

import java.net.URL

class Superhero(val superhero: String, val publisher: String, val realName: String, var photo: String)

fun ingresarSuperheroes(): List<Superhero> {
    val superheroes = mutableListOf<Superhero>()

    while (true) {
        println("Ingrese el nombre del superhéroe (o escriba 'salir' para terminar):")
        val nombre = readLine() ?: ""
        if (nombre == "salir") {
            break
        }

        println("Ingrese el nombre del publisher:")
        val publisher = readLine() ?: ""

        println("Ingrese el nombre real del superhéroe:")
        val nombreReal = readLine() ?: ""

        var foto: String
        while (true) {
            println("Ingrese la URL de la foto del superhéroe:")
            foto = readLine() ?: ""

            if (isValidUrl(foto)) {
                break
            } else {
                println("URL inválida. Intente nuevamente.")
            }
        }


        val superheroe = Superhero(nombre, publisher, nombreReal, foto)
        superheroes.add(superheroe)
    }

    return superheroes
}
fun isValidUrl(urlString: String): Boolean {
    try {
        val url = URL(urlString)
        // Verificar si la conexión se puede abrir (esto no descarga la imagen, solo verifica la URL)
        url.openConnection().connect()
        return true
    } catch (e: Exception) {
        return false
    }
}
fun imprimirSuperheroes(superheroes: List<Superhero>) {
    println("Lista de Superhéroes:")
    for (superheroe in superheroes) {
        println("Superhéroe: ${superheroe.superhero}")
        println("Publisher: ${superheroe.publisher}")
        println("Nombre Real: ${superheroe.realName}")
        println("Foto: ${superheroe.photo}")
        println()
    }
}

fun main() {
    val superheroes = ingresarSuperheroes()
    imprimirSuperheroes(superheroes)
}
