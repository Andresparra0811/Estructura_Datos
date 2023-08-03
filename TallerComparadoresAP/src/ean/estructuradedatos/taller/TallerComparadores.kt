/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller Objetos Comparadores
 * Autor: EAN - Octubre 12, 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.estructuradedatos.taller

import java.util.*
import kotlin.Comparator

data class SuperHéroe(val nombre: String, val poder: Int, val universo: String): Comparable<SuperHéroe> {
    /**
     * Primer criterio de comparación es el nombre, y el segundo será el poder.
     * Compares this object with the specified object for order. Returns zero if this object is equal
     * to the specified [other] object, a negative number if it's less than [other], or a positive number
     * if it's greater than [other].
     */
    override fun compareTo(other: SuperHéroe): Int {
        return compareValuesBy(this, other, SuperHéroe::nombre, SuperHéroe::poder)
    }

}

/**
 * Clase que representa la información de un producto.
 * Use el precio del producto como criterio de comparación.
 */

data class Producto(var nombre: String, var precio: Double, var cantidad: Int) : Comparable<Producto> {


    override fun compareTo(other: Producto): Int {

        if (this.precio == other.precio) {
            return 0
            }
        else if (this.precio< other.precio) {
                return -1
            }
        else {
                return 1
            }

    }

}

//--------------------------------------------------------------------

class ComparadorDeProductosPorNombre : Comparator<Producto> {

    // Compara los productos por nombre
    override fun compare(o1: Producto?, o2: Producto?): Int {
        return compareValues(o1!!.nombre, o2!!.nombre)
    }

}

object ComparadorPorNombreYPrecio : Comparator<Producto> {

    override fun compare(o1: Producto?, o2: Producto?): Int {
        return compareValuesBy(o1!!, o2!!, Producto::nombre, Producto::precio)
    }

}

object comparadorPorCantidad: Comparator<Producto> {

    override fun compare(o1: Producto?, o2: Producto?): Int {
        return compareValues(o1!!.cantidad, o2!!.cantidad)
    }
}

/**
 * Clase que representa un Reloj
 */
class Reloj : Comparable<Reloj> {
    /*
    Atributos: Un reloj tiene horas, minutos y segundos.
    La hora están 0 y 23, los minutos y segundos entre 0 y 59
     */
    private var hora:Int = 0
    private var minutos:Int = 0
    private var segundos:Int = 0


    /**
     * Agregue un constructor que inicialice el reloj en la hora actual del computador (este es el constructor por
     * defecto) y un constructutor que tenga los 3 elementos e inicialice los atributos en esos tres elementos. Use
     * precondiciones para verificar las condiciones sobre los atributos.
     */
    constructor() {
        var calendario = Calendar.getInstance()
        hora = calendario.get(Calendar.HOUR_OF_DAY)
        minutos = calendario.get(Calendar.MINUTE)
        segundos = calendario.get(Calendar.SECOND)

    }

    constructor(horas: Int, minutos: Int, segundos: Int) {
        require(horas<24)
        require(minutos<60)
        require(segundos<60)

        this.hora = horas
        this.minutos = minutos
        this.segundos = segundos

    }

    /*
     * Agregue una función toString que muestre la hora en formato hh:mm:ss
     * y otra función toAMPMString que muestre el tiempo en hh:mm:ss AMPM
     */


    override fun toString(): String {

        if (this.hora< 10 && this.minutos < 10 && this.segundos< 10){
            return ("0$hora:0$minutos:0$segundos")
        }
        else if (this.hora< 10 && this.minutos < 10){
            return ("0$hora:0$minutos:$segundos")
        }
        else if (this.hora< 10 && this.segundos < 10){
            return ("0$hora:$minutos:0$segundos")
        }
        else if (this.minutos< 10 && this.segundos < 10){
            return ("$hora:0$minutos:0$segundos")
        }
        else if (this.hora < 10){
            return ("0$hora:$minutos:$segundos")
        }
        else if (this.minutos < 10){
            return ("$hora:0$minutos:$segundos")
        }
        else if (this.segundos< 10){
            return ("$hora:$minutos:0$segundos")
        }
        else{
            return ("$hora:$minutos:$segundos")
        }
    }

    fun toAMPMString(): String {
        if (this.hora > 12){
            var residuoHora= this.hora % 12

            if (residuoHora< 10 && this.minutos < 10 && this.segundos< 10){
                return ("0$residuoHora:0$minutos:0$segundos PM" )
            }
            else if (residuoHora< 10 && this.minutos < 10){
                return ("0$residuoHora:0$minutos:$segundos PM")
            }
            else if (residuoHora < 10 && this.segundos <10){
                return ("0$residuoHora:$minutos:0$segundos PM")
            }
            else if (this.minutos< 10 && this.segundos < 10){
                return ("$residuoHora:0$minutos:0$segundos PM")
            }
            else if (residuoHora < 10){
                return ("0$residuoHora:$minutos:$segundos PM")
            }
            else if (this.minutos < 10){
                return ("$residuoHora:0$minutos:$segundos PM")
            }
            else if (this.segundos< 10){
                return ("$residuoHora:$minutos:0$segundos PM")
            }
            else{
                return ("$residuoHora : $minutos : $segundos PM")
            }

        }
        else{

            if (this.hora< 10 && this.minutos < 10 && this.segundos< 10){
                return ("0$hora:0$minutos:0$segundos AM")
            }
            else if (this.hora< 10 && this.minutos < 10){
                return ("0$hora:0$minutos:$segundos AM")
            }
            else if (this.hora< 10 && this.segundos < 10){
                return ("0$hora:$minutos:0$segundos AM")
            }
            else if (this.minutos< 10 && this.segundos < 10){
                return ("$hora:0$minutos:0$segundos AM")
            }
            else if (this.hora < 10){
                return ("0$hora:$minutos:$segundos AM")
            }
            else if (this.minutos < 10){
                return ("$hora:0$minutos:$segundos AM")
            }
            else if (this.segundos< 10){
                return ("$hora:$minutos:0$segundos AM")
            }
            else{
            return ("$hora : $minutos : $segundos AM")
            }
        }
    }

    /*
     * Agregue métodos para avanzar el reloj un segundo y otro para retrocederlo un segundo.
     * Adicionalmente un método equals.
     */
    fun avanzarUnSegundo() {
        if (this.segundos == 59){
            this.segundos = 0
            if (this.minutos==59){
                if (this.hora == 23){
                    this.hora = 0
                    this.minutos=0
                    this.segundos=0
                }
                else{
                    this.hora++
                }
            }
            else{
                this.minutos++
            }
        }
        else{
            this.segundos ++
        }
    }

    fun retrocederUnSegundo() {
        if (this.segundos==0){
            if (this.minutos==0){
                if (this.hora==0){
                    this.hora=23
                    this.minutos=59
                    this.segundos=59
                }
                else{
                    this.hora --
                }
            }
            else{
                this.minutos --
            }

        }
        else{
            this.segundos --
        }
    }



    /**
     * La función de comparación
     */
    override fun compareTo(other: Reloj): Int {

       if ((this.hora != 0 && this.minutos != 0 && this.segundos != 0) && (other.hora == 0 && other.minutos == 0 && other.segundos == 0)){
            return 1
        }
       else if ((this.hora == 0 && this.minutos == 0 && this.segundos == 0) && (other.hora != 0 && other.minutos != 0 && other.segundos != 0)){
            return -1
        }
        else{
           return compareValuesBy(this, other, Reloj::hora, Reloj::minutos, Reloj::segundos)
        }

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}
