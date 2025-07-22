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

    val multiplicacion = fraccion1 * fraccion2
    println("Multiplicación: $multiplicacion")

    val division = fraccion1 / fraccion2
    println("División: $division")

    println("¿Fracción 1 es mayor que Fracción 2? ${fraccion1.esMayor(fraccion2)}")
    println("¿Fracción 1 es menor que Fracción 2? ${fraccion1.esMenor(fraccion2)}")
    println("¿Son iguales? ${fraccion1 == fraccion2}")
    println("Fracción 1 en decimal: ${fraccion1.aDecimal()}")

    val desdeDecimal = Fraccion.desdeDecimal(0.75)
    println("Fracción creada desde 0.75: $desdeDecimal")
}
