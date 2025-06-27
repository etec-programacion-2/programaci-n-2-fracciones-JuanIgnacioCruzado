package org.example

class Fraccion(
    private var _numerador : Int,
    private var _denominador: Int
) {
    var numerador: Int
        get() = _numerador
        set(value) {
            _numerador = value
        }

    var denominador: Int
        get() = _denominador
        set(value) {
            require(value != 0) { "El denominador no puede ser cero." }
            _denominador = value
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

    fun obtenerValor(): String {
        return toString()
    }

    override fun toString(): String {
        return "$_numerador / $_denominador"
    }
}
