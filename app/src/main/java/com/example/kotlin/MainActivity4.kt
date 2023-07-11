package com.example.kotlin

// parte B ejercicio 22 v2

// clase Bid que representa una oferta en una subasta y tiene un atributo amount que indica el importe de la oferta
data class Bid(val amount: Int)
fun auctionPrice(bid: Bid?) { //bid?= anulable
    val price = bid?.amount ?: 0 // ?:= operador elvis, para asignar un valor de 0 a la variable "price" si "bid" es nulo.
    println("Precio de la subasta: $price")

    if (bid == null || bid.amount <= 0) {
        println("El artículo se vende automáticamente al precio mínimo.")
    } else {
        println("El ofertante determina el precio del artículo.")
    }
}
fun main() { //se crean dos importes 100 y 0 o nulo
    val bid1 = Bid(100)
    val bid2: Bid? = null
    //se llama a la funcion
    auctionPrice(bid1)
    auctionPrice(bid2)
}
