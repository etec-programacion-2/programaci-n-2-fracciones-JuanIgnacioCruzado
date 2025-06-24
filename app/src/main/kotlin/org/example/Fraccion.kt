
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
            _denominador = value
        }  

    fun obtenerValor(): String {
        return toString()
    }
    override fun toString(): String {
       return "${_numerador} / ${_denominador}"              
    }
}