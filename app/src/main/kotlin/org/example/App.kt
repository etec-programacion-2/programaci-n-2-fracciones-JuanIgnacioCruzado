package org.example

fun main() {
    val fraccion1 = Fraccion(3, 4)
    val fraccion2 = Fraccion(5, 6)

    println("Fracción 1: $fraccion1")
    println("Fracción 2: $fraccion2")

    val suma = fraccion1 + fraccion2
    println("Suma: $suma")

    val resta = fraccion1 - fraccion2
    println("Resta: $resta")
}
