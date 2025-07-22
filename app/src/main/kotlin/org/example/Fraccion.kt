package org.example

class Fraccion(
    private var _numerador: Int,
    private var _denominador: Int
) : Comparable<Fraccion> {

    var numerador: Int
        get() = _numerador
        set(value) {
            _numerador = value
            simplificar()
        }

    var denominador: Int
        get() = _denominador
        set(value) {
            require(value != 0) { "El denominador no puede ser cero." }
            _denominador = value
            simplificar()
        }

    init {
        require(_denominador != 0) { "El denominador no puede ser cero." }
        simplificar()
    }

    operator fun plus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.denominador + this.denominador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun minus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.denominador - this.denominador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun times(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.numerador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun div(otra: Fraccion): Fraccion {
        require(otra.numerador != 0) { "No se puede dividir por una fracción con numerador 0 (división por cero)." }
        val nuevoNumerador = this.numerador * otra.denominador
        val nuevoDenominador = this.denominador * otra.numerador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraccion) return false
        return this.numerador == other.numerador && this.denominador == other.denominador
    }

    override fun compareTo(otra: Fraccion): Int {
        val diferencia = this.numerador * otra.denominador - otra.numerador * this.denominador
        return diferencia.compareTo(0)
    }

    fun esMayor(otra: Fraccion): Boolean = this > otra

    fun esMenor(otra: Fraccion): Boolean = this < otra

    fun aDecimal(): Double = numerador.toDouble() / denominador

    companion object {
        fun desdeDecimal(decimal: Double): Fraccion {
            val precision = 1_000_000
            val numerador = (decimal * precision).toInt()
            val denominador = precision
            return Fraccion(numerador, denominador)
        }
    }

    private fun simplificar() {
        val mcd = mcd(_numerador, _denominador)
        _numerador /= mcd
        _denominador /= mcd
        if (_denominador < 0) {
            _numerador *= -1
            _denominador *= -1
        }
    }

    private fun mcd(a: Int, b: Int): Int {
        var x = kotlin.math.abs(a)
        var y = kotlin.math.abs(b)
        while (y != 0) {
            val resto = x % y
            x = y
            y = resto
        }
        return x
    }

    override fun toString(): String {
        return "$_numerador / $_denominador"
    }
}
