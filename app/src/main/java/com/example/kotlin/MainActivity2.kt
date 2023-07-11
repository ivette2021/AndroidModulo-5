package com.example.kotlin

data class Bid(val amount: Int)
fun auctionPrice(bid: Bid?) {
    val price = bid?.amount ?: 0
    println("Precio de la subasta: $price")

    if (bid == null || bid.amount <= 0) {
        println("El artículo se vende automáticamente al precio mínimo.")
    } else {
        println("El ofertante determina el precio del artículo.")
    }
}
fun main() {
    val bid1 = Bid(100)
    val bid2: Bid? = null

    auctionPrice(bid1)
    auctionPrice(bid2)
}